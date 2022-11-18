package com.sammid37.leitura.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sammid37.leitura.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
  // Query para verificar casos de leituras duplicadas, ou seja, leituras que possuam mesmo título e autor
  @Query("SELECT l FROM Livro l WHERE l.titulo = ?1 AND l.autor = ?2")
  List<Livro> findByTituloAutor(String titulo, String autor); 
    
  @Query("SELECT l FROM Livro l WHERE l.review LIKE %?1%")
  List<Livro> findByReview(String review);

  @Query("SELECT l FROM Livro l WHERE year(l.data_leitura) = year(?1) AND month(l.data_leitura) = month(?1)")
  List<Livro> findByYearMonth(Date data_leitura);

}
