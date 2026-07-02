package com.livraria.api.service;

import com.livraria.api.entity.Autor;
import com.livraria.api.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl implements AutorService {
    private final AutorRepository autorRepository;

    public AutorServiceImpl(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    @Override
    public Autor salvarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Autor buscarPorId(Integer id) {
        return autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor não encontrado com o id: " + id));
    }

    @Override
    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }
}
