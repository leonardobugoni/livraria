package io.github.leonardobugoni.livraria.repository;

import io.github.leonardobugoni.livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository <Livro, Long> {
}
