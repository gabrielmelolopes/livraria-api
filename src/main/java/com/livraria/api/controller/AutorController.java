package com.livraria.api.controller;

import com.livraria.api.dto.AutorRequestDTO;
import com.livraria.api.dto.AutorResponseDTO;
import com.livraria.api.entity.Autor;
import com.livraria.api.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {
    private final AutorService autorService;

    public AutorController(AutorService autorService){this.autorService = autorService;}

    @PostMapping()
    public ResponseEntity<AutorResponseDTO> criarAutor(@RequestBody @Valid AutorRequestDTO autorRequestDTO){
        Autor autor = new Autor();
        autor.setNome(autorRequestDTO.nome());
        autor.setNacionalidade(autorRequestDTO.nacionalidade());
        Autor autorRetornado = autorService.salvarAutor(autor);
        AutorResponseDTO autorResponseDTO = new AutorResponseDTO(
                autorRetornado.getId(),
                autorRetornado.getNome(),
                autorRetornado.getNacionalidade()
        );

        return ResponseEntity.ok(autorResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorResponseDTO> buscarAutorPorId(@PathVariable Integer id){
        Autor autorRetornado = autorService.buscarPorId(id);

        AutorResponseDTO autorResponseDTO = new AutorResponseDTO(
                autorRetornado.getId(),
                autorRetornado.getNome(),
                autorRetornado.getNacionalidade()
        );

        return ResponseEntity.ok(autorResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<AutorResponseDTO>> listarTodos(){
        List<Autor> autorRetornado = autorService.listarTodos();
        List<AutorResponseDTO> response = new ArrayList<>();
        for(Autor a : autorRetornado){
            AutorResponseDTO autorResponse = new AutorResponseDTO(
                    a.getId(),
                    a.getNome(),
                    a.getNacionalidade()
            );
            response.add(autorResponse);
        }
        return ResponseEntity.ok(response);
    }

}
