package com.livraria.api.service;

import com.livraria.api.entity.Livro;
import com.livraria.api.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LivroServiceImpl implements LivroService {
    private final LivroRepository livroRepository;

    public LivroServiceImpl(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    @Override
    public Livro salvarLivro(Livro livro) {
        if(livro.getPreco().compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("Valor negativo");
        }
        return livroRepository.save(livro);
    }

    @Override
    public Livro buscarPorId(Integer id) {
        return livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado com o id: " + id));
    }

    @Override
    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    @Override
    public List<Livro> listarPorAutor(Integer id) {
        return livroRepository.findByAutorId(id);
    }
}
