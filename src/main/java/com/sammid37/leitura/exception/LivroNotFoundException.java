package com.sammid37.leitura.exception;

public class LivroNotFoundException extends RuntimeException {
  public LivroNotFoundException(int id) {
    super("Não foi possivel encontrar o livro correspondente ao id #" + id);
  } 
}
