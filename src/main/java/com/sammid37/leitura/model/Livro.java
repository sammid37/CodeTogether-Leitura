package com.sammid37.leitura.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class Livro {
    @Id
    @GeneratedValue
    private int id;

    // atributos
    /*
     * @Table(name = "livro", uniqueConstraints = @UniqueConstraint(columnNames = { "titulo", "autor" }))
     */
    @NotNull(message = "O título da obra não pode ser nulo.")
    @NotEmpty(message = "O título da obra não pode ser vazio.")
    private String titulo;

    @NotNull(message = "O nome do autor não pode ser nulo.")
    @NotEmpty(message = "O nome do autor não pode ser vazio.")
    private String autor;

    private String editora;

    @Temporal(TemporalType.DATE) // define o tipo temporal
    @Past // Data informada válida caso ela seja igual ou anterior à hoje
    private Date data_leitura;

    // Novos atributos (2ª quinzena de implementação)
    String categoria = "Outros";

    @Size(max = 500, message = "Você atingiu o limite de caracteres da review")
    String review;
    
    @DecimalMin("0.0")
    @DecimalMax("5.0")
    float nota = 0.0f;
    
    // Métodos Get e Set
    /*
     * O que são os métodos GET e SET para a entidade/modelo? 
     - Encapsulamento
     - Declaração de atributos e variáveis de uma classe de forma privada (só pode ser acessados pela mesma classe)
     - Métodos públicos para acessar e atualizar os valores de uma variavel privada
     */
    // ID
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    // Título da obra
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    // Autor
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    // Editora
    public String getEditora() { return editora; }
    public void setEditora(String editora) { this.editora = editora; }

    // Data da leitura
    public Date getDataLeitura() { return data_leitura; }
    public void setDataLeitura(Date data_leitura) { this.data_leitura = data_leitura; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }

    public float getNota() { return nota; }
    public void setNota(float nota) { this.nota = nota; }
}
