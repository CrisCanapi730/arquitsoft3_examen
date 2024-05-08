package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class Products {

    @Operation(summary = "Get a greeting message")
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        String greeting = "Hola!";
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

    @Operation(summary = "Trigger a forced error")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/fail")
    public ResponseEntity<String> fail() {
        throw new RuntimeException("This is a forced error");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        // Aquí deberías validar las credenciales de inicio de sesión y generar un token si son válidas.
        // Este es solo un ejemplo, así que vamos a devolver un token y una marca de tiempo ficticios.

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken("ficticio");
        loginResponse.setTimestamp(String.valueOf(System.currentTimeMillis()));

        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/pay")
    public ResponseEntity<CardPaymentResponse> pay(@RequestBody CardPaymentRequest paymentRequest) {
        // Aquí deberías procesar el pago y devolver una respuesta apropiada.
        // Este es solo un ejemplo, así que vamos a devolver un código de estado y un mensaje ficticios.

        CardPaymentResponse paymentResponse = new CardPaymentResponse();
        paymentResponse.setStatusCode(0);
        paymentResponse.setMessage("successful");

        return ResponseEntity.ok(paymentResponse);
    }
}
