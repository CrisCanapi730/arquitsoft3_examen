package com.example.demo;

public class CardPaymentResponse {
    private int statusCode;
    private String message;

    // Getters and setters...
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
