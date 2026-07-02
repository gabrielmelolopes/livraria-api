package com.livraria.api.service;

import com.livraria.api.entity.Livro;

import java.util.List;

public interface LivroService {
    Livro salvarLivro(Livro livro);
    Livro buscarPorId(Integer id);
    List<Livro> listarTodos();
    List<Livro> listarPorAutor(Integer id);
}