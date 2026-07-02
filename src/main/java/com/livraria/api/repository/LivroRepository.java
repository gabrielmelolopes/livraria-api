package com.livraria.api.repository;

import com.livraria.api.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
    List<Livro> findByAutorId(Integer id);
}
