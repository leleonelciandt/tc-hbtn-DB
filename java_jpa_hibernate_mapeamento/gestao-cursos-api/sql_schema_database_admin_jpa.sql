-- TABLE
CREATE TABLE Aluno (id  integer, email varchar(255), matricula varchar(255), nascimento date, nomeCompleto varchar(255), primary key (id));
CREATE TABLE Alunos_Curso (id_curso bigint not null, id_aluno bigint not null);
CREATE TABLE Curso (id  integer, nome varchar(255), sigla varchar(255), id_material bigint not null, id_professor bigint not null, primary key (id), unique (id_material));
CREATE TABLE Endereco (id  integer, bairro varchar(255), cep integer, cidade varchar(255), endereco varchar(255), estado varchar(255), logradouro varchar(255), numero varchar(255), aluno_id bigint, id_endereco bigint, primary key (id));
CREATE TABLE MaterialCurso (id  integer, url varchar(255), primary key (id));
CREATE TABLE Professor (id  integer, email varchar(255), matricula varchar(255), nomeCompleto varchar(255), primary key (id));
CREATE TABLE Telefone (id  integer, ddd varchar(255), numero varchar(255), id_telefone bigint, primary key (id));
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 
