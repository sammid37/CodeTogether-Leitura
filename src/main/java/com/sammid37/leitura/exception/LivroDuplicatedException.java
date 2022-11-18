package com.sammid37.leitura.exception;

public class LivroDuplicatedException extends RuntimeException {
  public LivroDuplicatedException(String titulo, String autor) {
    super("O livro "+ titulo +" do autor "+ autor +" já foi cadastrado. Não é possível cadastrar leituras duplicadas.");
  }
}
