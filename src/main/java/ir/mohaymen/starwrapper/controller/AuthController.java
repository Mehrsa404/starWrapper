package ir.mohaymen.starwrapper.controller;

import com.fasterxml.jackson.databind.JsonNode;
import ir.mohaymen.starwrapper.domain.LoginDto;
import ir.mohaymen.starwrapper.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/star-wrapper/api/AM")
@RequiredArgsConstructor
public class AuthController {

    private final LoginService loginService;

    @PostMapping(value = "/login")
    public ResponseEntity<JsonNode> login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {

        return loginService.login(username, password);
//        return new LoginDto(); // هر چیزی که DTO می‌پذیرد

    }
}
