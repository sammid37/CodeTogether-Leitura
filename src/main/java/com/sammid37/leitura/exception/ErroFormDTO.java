package com.sammid37.leitura.exception;

public class ErroFormDTO {
  private String campo; // nome do campo que não foi validado
  private String erro; // mensagem de erro

  public ErroFormDTO(String campo, String erro) {
    this.campo = campo;
    this.erro = erro;
  }

  public String getCampo() { return campo; }
  public String getErro() { return erro; }

}
