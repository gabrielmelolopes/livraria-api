package com.livraria.api.controller;

import com.livraria.api.dto.AutorResumoDTO;
import com.livraria.api.dto.LivroRequestDTO;
import com.livraria.api.dto.LivroResponseDTO;
import com.livraria.api.entity.Autor;
import com.livraria.api.entity.Livro;
import com.livraria.api.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService){this.livroService = livroService;}

    @PostMapping()
    public ResponseEntity<LivroResponseDTO> criarLivro(@RequestBody @Valid LivroRequestDTO livroRequestDTO){
        Livro livro = new Livro();
        livro.setTitulo(livroRequestDTO.titulo());
        livro.setPreco(livroRequestDTO.preco());
        livro.setAno_publicacao(livroRequestDTO.ano_publicacao());
        livro.setAutor(livroRequestDTO.autor());
        Livro livroRetornado = livroService.salvarLivro(livro);
        AutorResumoDTO autorResumoDTO = new AutorResumoDTO(livroRetornado.getAutor().getId(), livroRetornado.getAutor().getNome());
        LivroResponseDTO response = new LivroResponseDTO(
                livroRetornado.getTitulo(),
                livroRetornado.getPreco(),
                livroRetornado.getAno_publicacao(),
                autorResumoDTO
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDTO> buscarPorId(@PathVariable Integer id){
        Livro livroRetornado = livroService.buscarPorId(id);
        AutorResumoDTO autorResumoDTO = new AutorResumoDTO(livroRetornado.getAutor().getId(), livroRetornado.getAutor().getNome());
        LivroResponseDTO response = new LivroResponseDTO(
                livroRetornado.getTitulo(),
                livroRetornado.getPreco(),
                livroRetornado.getAno_publicacao(),
                autorResumoDTO
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<LivroResponseDTO>> listarTodos(){
        List<Livro> livroRetornado = livroService.listarTodos();
        List<LivroResponseDTO> response = new ArrayList<>();
        for(Livro l : livroRetornado){
            AutorResumoDTO autorResumoDTO = new AutorResumoDTO(l.getAutor().getId(), l.getAutor().getNome());
            LivroResponseDTO livroResponse = new LivroResponseDTO(
                    l.getTitulo(),
                    l.getPreco(),
                    l.getAno_publicacao(),
                    autorResumoDTO
            );
            response.add(livroResponse);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/autor/{id}")
    public ResponseEntity<List<LivroResponseDTO>> listarPorAutor(@PathVariable Integer id){
        List<Livro> livroRetornado = livroService.listarPorAutor(id);
        List<LivroResponseDTO> response = new ArrayList<>();
        for(Livro l : livroRetornado) {
            AutorResumoDTO autorResumoDTO = new AutorResumoDTO(l.getAutor().getId(), l.getAutor().getNome());
            LivroResponseDTO livroResponse = new LivroResponseDTO(
                    l.getTitulo(),
                    l.getPreco(),
                    l.getAno_publicacao(),
                    autorResumoDTO
            );
            response.add(livroResponse);
        }
        return ResponseEntity.ok(response);
    }
}
