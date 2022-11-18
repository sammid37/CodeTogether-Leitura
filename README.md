# Leitura

Projeto desenvolvido com a comunidade Code Together do [PET Computação](https://linktr.ee/petcomufpb).

O projeto *Leitura* é uma API que segue o padrão REST na qual é possível realizar o cadastro de leituras.

## 💻 Tecnologias utilizadas
* Spring initializr para gerar o projeto Spring seguinto o formato Maven;
* Insomnia para realizar os testes da API.

## 💻 Implementações
Os encontros da comunidade Code Together ocorreram quinzenalmente e assim eram apresentados os novos requisitos do projeto. 
A seguir estão listados os requsitos referente ao período de implementação.

> As implementações referentes às quinzenas podem ser visualizadas no seguinte diretório `/src/main/java/com/sammid37/leitura/`, onde: 
> * `Model`: modelagem da classe
> * `Repository`: regras e queries
> * `Controller`: requisições (GET, POST, PUT e DELETE)

### 📖 Quinzena 1
* Modelagem do Banco de Dados 
* Cadastro de leituras
* Listagem de todas as leituras
* Listagem de leitura por id
* Atualização de leitura
* Exclusão de leitura


### 📖 Quinzena 22
* Atualização do Banco de Dados
* Permitir avaliar leitura com uma nota e uma review
* Categorizar uma leitura (por padrão: "Outros")
* Listagem de leituras por palavra da review
* Listagem de leituras do mês (ex.: agosto de 2022)

### 🫥 Quinzena 3
Em breve.
### 🤔Próximos passos


## 🎯 Endpoints
|**endpoint**|**router**|**description**|
|----|----|----|
|**`get`**|`/livro`|Lista todos os livros cadastrados.|
|**`get`**|`/livro/{id}`|Detalha um livro por id.|
|**`get`**|`livro/r?review=excelente`|Retorna os livros que possuem, por exemplo, a palavra *excelente* na review.|
|**`get`**|`livro/resumo/2010-04`|Retorna a lista de livros lidos no mês e ano fornecido, por exemplo: leituras de abril de 2010.|
|**`put`**|`/livro/{id}`|Atualiza os dados do livro informado.|
|**`delete`**|`/livro/{id}`|Remove o livro informado da base de dados.|


