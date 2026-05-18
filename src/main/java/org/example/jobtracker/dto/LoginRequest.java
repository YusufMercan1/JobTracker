package org.example.jobtracker.dto;


public record LoginRequest(
        String username,
        String password
) {}
