package com.livraria.api.dto;

import com.livraria.api.entity.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record LivroRequestDTO(
        @NotBlank String titulo,
        @NotNull BigDecimal preco,
        @NotNull Integer ano_publicacao,
        @NotNull Autor autor
) {}
