package ir.mohaymen.starwrapper.client;

import com.fasterxml.jackson.databind.JsonNode;
import ir.mohaymen.starwrapper.config.FeingClientConfig;
import ir.mohaymen.starwrapper.domain.LoginRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "AM-service", url = "https://web-star-nta.abriment.mohaymen.ir", configuration = FeingClientConfig.class // املای درست
)
public interface AMClient {

    @PostMapping(value = "/gateway/MSSE.AM/api/IdentityManagementApi/Login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<JsonNode> login(@RequestParam("Mrpc-EngineName") String engineName,
                                   @RequestParam("Mrpc-EngineVersion") String engineVersion,
                                   @RequestParam("W_MultiTech") boolean multiTech,
                                   @RequestParam("W_InputAsArray") boolean inputAsArray,
                                   @RequestParam("W_HandlingMode") int handlingMode,
                                   @RequestBody List<LoginRequest> body);
}
