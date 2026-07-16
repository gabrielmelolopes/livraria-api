package com.livraria.api.dto;

import java.math.BigDecimal;

public record LivroResponseDTO(
        Integer id,
        String titulo,
        BigDecimal preco,
        Integer ano_publicacao,
        AutorResumoDTO autorResumoDTO
) {}
