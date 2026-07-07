package com.livraria.api.service;

import com.livraria.api.entity.Livro;
import com.livraria.api.repository.LivroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LivroServiceImplTest {
    @Mock
    LivroRepository livroRepository;

    @InjectMocks
    LivroServiceImpl livroService;

    @Test
    public void deveLancarExcecao_quandoPrecoForNegativo(){
        Livro livro = new Livro();
        livro.setTitulo("O Hobbit");
        livro.setPreco(BigDecimal.valueOf(-10));
        livro.setAno_publicacao(1937);

        assertThrows(RuntimeException.class, () ->{
            livroService.salvarLivro(livro);
        });
    }

    @Test
    public void deveLancarExcecao_quandoBuscarLivroPorIdInexistente(){
        when(livroRepository.findById(99)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> livroService.buscarPorId(99));
    }
}
