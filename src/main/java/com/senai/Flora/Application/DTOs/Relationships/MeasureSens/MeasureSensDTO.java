package com.senai.Flora.Application.DTOs.Relationships.MeasureSens;

import java.time.LocalDate;

public record MeasureSensDTO(
        Long id,
        Long idSens,
        Long idMeasure,
        LocalDate attributionDate
) {
}


/*Quando esse formato é o ideal

Esse tipo de DTO (apenas com IDs) é o mais indicado quando:

A API apenas recebe os IDs e, dentro do serviço, você busca as entidades no banco antes de salvar.

Ou seja: você não precisa enviar o objeto Sens inteiro via JSON.
*/