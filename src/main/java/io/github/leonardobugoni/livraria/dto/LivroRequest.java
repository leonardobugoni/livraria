package io.github.leonardobugoni.livraria.dto;

import io.github.leonardobugoni.livraria.model.Livro;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    @Size(max = 200)
    private String titulo;

    @NotBlank
    @Size(max = 4000)
    private String descricao;

    @Past
    private LocalDate dataPublicacao;

    @ISBN
    private String isbn;

    public LivroRequest(String titulo, String descricao, LocalDate dataPublicacao, String isbn) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPublicacao = dataPublicacao;
        this.isbn = isbn;
    }

    @Deprecated
    public LivroRequest() {
    }

    public Livro paraLivro(){
        return new Livro(titulo, descricao, dataPublicacao, isbn);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }
}
