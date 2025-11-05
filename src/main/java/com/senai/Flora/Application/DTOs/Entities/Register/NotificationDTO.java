package com.senai.Flora.Application.DTOs.Entities.Register;

import java.time.LocalDate;

public record NotificationDTO(
        Long id,
        Long id_Sens,
        LocalDate attributionDate
) {
}
