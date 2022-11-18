package com.sammid37.leitura.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RestController;

import com.sammid37.leitura.model.Livro;
import com.sammid37.leitura.repository.LivroRepository;
import com.sammid37.leitura.exception.LivroDuplicatedException;
import com.sammid37.leitura.exception.LivroNotFoundException;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {
  @Autowired
  private LivroRepository livroRepository;

  // Listagem
  // Listar todos
  @GetMapping
  List<Livro> getAllLivros() {
    return livroRepository.findAll();
  }
  // Listar ou detalhar por ID
  @GetMapping("/{id}")
  Livro getLivroById(@PathVariable int id) {
    return livroRepository.findById(id).orElseThrow(() -> new LivroNotFoundException(id));
  }

  // Listar ou detalhar por review
  @GetMapping("r") 
  List<Livro> getLivroByReview(@RequestParam(defaultValue = "legal") String review) {
    return livroRepository.findByReview(review);
  }
  
  @GetMapping("/resumo/{data_leitura}") // 2022-08
  List<Livro> getLivroByDatas(@PathVariable @DateTimeFormat(pattern = "yyyy-MM") Date data_leitura) {
    return livroRepository.findByYearMonth(data_leitura);
  }

  // Cadastro
  //* Falta validar a categoria informada no momento do cadastro
  /*
  - Conto
  - Poesia
  - Biografia
  - Terror
  - Sci-Fi
  - Outros)
  */
  @PostMapping
  Livro newLivro(@Valid @RequestBody Livro newLivro) {
    // Armazenando o título e o autor informados no corpo da requisição
    String titulo = newLivro.getTitulo();
    String autor = newLivro.getAutor();
    
    List<Livro> l = livroRepository.findByTituloAutor(titulo, autor);

    // Verifica se a leitura já foi cadastrada
    if(l.size() >= 1){
      throw new LivroDuplicatedException(titulo, autor);
    } else {
      return livroRepository.save(newLivro);
    }
  }

  // Atualização do cadastro de um livro por ID
  @PutMapping("/{id}")
  Livro updateLivro(@Valid @RequestBody Livro newLivro, @PathVariable int id) {
    return livroRepository.findById(id)
      .map(livro -> {
        livro.setTitulo(newLivro.getTitulo());
        livro.setAutor(newLivro.getAutor());
        livro.setEditora(newLivro.getEditora());
        livro.setDataLeitura(newLivro.getDataLeitura());
        livro.setCategoria(newLivro.getCategoria());
        livro.setNota(newLivro.getNota());
        livro.setReview(newLivro.getReview());

        return livroRepository.save(livro);
    }).orElseThrow(() -> new LivroNotFoundException(id));
  }

  // Deletar livro por ID
  @DeleteMapping("/{id}")
  String deleteLivro(@PathVariable int id) {
    if(!livroRepository.existsById(id)) {
      throw new LivroNotFoundException(id);
    }
    livroRepository.deleteById(id);
    return "Livro com o id #"+id+" foi deletado com sucesso.";
  }

}
