package org.example.jobtracker.dto;

import org.example.jobtracker.model.Status;

import java.time.LocalDate;

public record JobApplicationResponse (
        Long id,
        String companyName,
        String role,
        Status status,
        LocalDate appliedDate,
        LocalDate deadline,
        String notes
) {}
