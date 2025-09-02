package ir.mohaymen.starwrapper.services;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;

public interface LoginService {
    ResponseEntity<JsonNode> login(String username, String password);
}
