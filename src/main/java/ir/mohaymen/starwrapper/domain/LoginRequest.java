package ir.mohaymen.starwrapper.domain;

import java.util.List;

public record LoginRequest(Client clien, String Password, String Username, String Nonce, String CaptchaId, String CaptchaInputValue) {
    public record Client(String ClientId, List<String> redirectUrls, List<String> Scopes) {
    }

}