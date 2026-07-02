package com.livraria.api.dto;

import jakarta.validation.constraints.NotBlank;

public record AutorRequestDTO(
        @NotBlank String nome,
        @NotBlank String nacionalidade
) {}
