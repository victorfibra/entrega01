package com.example.entrega01.dto;

import com.example.entrega01.model.StatusConsumo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record ContratoResponseDTO(
    //Long id, 
    @NotBlank String cliente, 
    //@NotBlank String login, 
    @PositiveOrZero Double totalTrafegoGB, 
    StatusConsumo status
) {}