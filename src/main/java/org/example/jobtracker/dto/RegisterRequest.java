package org.example.jobtracker.dto;

public record RegisterRequest(
        String username,
        String email,
        String password
) {}
