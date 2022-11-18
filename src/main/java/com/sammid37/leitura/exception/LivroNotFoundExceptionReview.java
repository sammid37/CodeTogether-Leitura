package com.sammid37.leitura.exception;

public class LivroNotFoundExceptionReview extends RuntimeException {
  public LivroNotFoundExceptionReview(String review) {
    super("Não foi possivel encontrar um livro que contenha a palavra <" + review + "> na review.");
  }   
}
