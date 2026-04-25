package com.api.controller;


import com.api.controller.adapter.AuthControllerAdapter;
import com.api.controller.dto.request.LoginRequest;
import com.api.controller.dto.response.AuthResponse;
import com.api.entity.Token;
import com.api.security.TokenSecurity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {
    private final TokenSecurity tokenSecurity;

    public AuthController(TokenSecurity tokenSecurity) {
        this.tokenSecurity = tokenSecurity;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/v1/auth")
    public AuthResponse login(@RequestBody LoginRequest request) {
        Token token = tokenSecurity.gerarToken(AuthControllerAdapter.cast(request));
        return new AuthResponse(token.value());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/v1/auth/forget/{username}")
    public String forgetPassword(@PathVariable("username") String username) {
        return "Olá " + username + " enviamos sua senha para o seu email";
    }
}