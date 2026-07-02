package com.livraria.api.service;

import com.livraria.api.entity.Autor;

import java.util.List;

public interface AutorService {
    Autor salvarAutor(Autor autor);
    Autor buscarPorId(Integer id);
    List<Autor> listarTodos();
}
