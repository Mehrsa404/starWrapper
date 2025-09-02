package ir.mohaymen.starwrapper.services;

import com.fasterxml.jackson.databind.JsonNode;
import ir.mohaymen.starwrapper.client.AMClient;
import ir.mohaymen.starwrapper.domain.LoginRequest;
import ir.mohaymen.starwrapper.token.NonceGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;


import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    @Value("${am.service.url}")
    private String amServiceUrl;

    @Value("${am.service.enginName}")
    private String amEngineName;

    @Value("${am.service.enginVersion}")
    private String amEngineVersion;

    @Value("${am.service.multiTech}")
    private boolean amMultiTech;

    @Value("${am.service.inputAsArray}")
    private boolean amInputAsArray;

    @Value("${am.service.handlingMode}")
    private int amHandlingMode;

    private final AMClient amClient;

    @Override
    public ResponseEntity<JsonNode> login(String username, String password) {

        LoginRequest.Client client =
                new LoginRequest.Client("web", List.of(amServiceUrl+'/'), List.of("openid", "profile"));

        LoginRequest loginRequest = new LoginRequest(client, password, username, NonceGenerator.generate(), null, null);

        // درخواست به میکروسرویس B
        ResponseEntity<JsonNode> response = amClient.login(amEngineName, amEngineVersion, amMultiTech, amInputAsArray, amHandlingMode, List.of(loginRequest));

        // گرفتن تمام Set-Cookie ها
        List<String> setCookies = response.getHeaders().get(HttpHeaders.SET_COOKIE);

        if (setCookies != null) {
            for (String sc : setCookies) {
                // پارس کردن همه کوکی ها
                for (java.net.HttpCookie cookie : java.net.HttpCookie.parse(sc)) {
                    // اگر اسم کوکی X-Auth-Token بود، پرینتش کن
                    if ("X-Auth-Token".equalsIgnoreCase(cookie.getName())) {
                        System.out.println("X-Auth-Token: " + cookie.getValue());
                    }
                }
            }
        } else {
            System.out.println("هیچ Set-Cookie در پاسخ وجود ندارد!");
        }

        return response;
    }
}
