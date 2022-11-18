-- create database leitura;
-- show tables;
-- describe livro;
use leitura;

select * from Livro;
select * from livro t where t.titulo="A culpa é das estrelas" and t.autor="John Green";

SELECT * FROM livro l WHERE l.review = "fofo";
SELECT * FROM livro l WHERE year(l.data_leitura) = 2016 AND month(l.data_leitura) = 08;