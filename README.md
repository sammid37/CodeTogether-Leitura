# Leitura

Projeto desenvolvido com a comunidade Code Together do [PET Computação](https://linktr.ee/petcomufpb).

O projeto *Leitura* é uma API que segue o padrão REST na qual é possível realizar o cadastro de leituras.

## 💻 Tecnologias utilizadas
* Spring initializr para gerar o projeto Spring seguinto o formato Maven;
* Insomnia para realizar os testes da API.

## 💻 Implementações
Os encontros da comunidade Code Together ocorreram quinzenalmente e assim eram apresentados os novos requisitos do projeto. 
A seguir estão listados os requsitos referente ao período de implementação.

### 📖 Quinzena 1
* Modelagem do Banco de Dados
* Cadastro de leituras
* Listagem de todas as leituras
* Listagem de leitura por id
* Atualização de leitura
* Exclusão de leitura

### 🫥 Quinzena 2
Em breve.
### 🫥 Quinzena 3
Em breve.
### 🤔Próximos passos


## 🎯 Endpoints
|**endpoint**|**router**|**description**|
|----|----|----|
|**`get`**|`/livro`|Lista todos os livros cadastrados|
|**`get`**|`/livro/{id}`|Detalha um livro por id|
|**`post`**|`/livro`|Cadastra um novo livro|
|**`put`**|`/livro/{id}`|Atualiza os dados do livro informado|
|**`delete`**|`/livro{id}`|Remove o livro informado da base de dados|


