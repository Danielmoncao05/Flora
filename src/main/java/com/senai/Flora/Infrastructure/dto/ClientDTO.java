package com.senai.Flora.Infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClientDTO(
        Long id,
        String name,
        Integer age,
        String email,
        String password

) {
}
