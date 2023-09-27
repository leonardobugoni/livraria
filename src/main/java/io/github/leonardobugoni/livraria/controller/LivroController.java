package io.github.leonardobugoni.livraria.controller;

import io.github.leonardobugoni.livraria.dto.LivroRequest;
import io.github.leonardobugoni.livraria.model.Livro;
import io.github.leonardobugoni.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping(value = "/livros")
    private ResponseEntity<Livro> cadastrarLivro(@RequestBody @Valid LivroRequest livro, UriComponentsBuilder uri){

        final Livro novoLivro = livroRepository.save(livro.paraLivro());
        final URI localtion = uri.path("/livros/{id}").buildAndExpand(novoLivro.getId()).toUri();
        return ResponseEntity.created(localtion).build();
    }

}
