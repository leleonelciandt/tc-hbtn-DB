package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.time.LocalDate;
import java.util.List;

public class GestaoCursosMain {
    public static void main(String[] args) {

        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        Endereco endereco1 = new Endereco();
        endereco1.setLogradouro("Rua");
        endereco1.setEndereco("Rua Sem Saída");
        endereco1.setNumero("0");
        endereco1.setBairro("Sem Bairro");
        endereco1.setCidade("Sem Cidade");
        endereco1.setEstado("SP");
        endereco1.setCep(0000000);

        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro("Rua");
        endereco2.setEndereco("Da Liberdade");
        endereco2.setNumero("0123");
        endereco2.setBairro("Presos");
        endereco2.setCidade("Sem Juízo");
        endereco2.setEstado("SP");
        endereco2.setCep(01234552);

        Telefone telefone1 = new Telefone();
        telefone1.setDdd("19");
        telefone1.setNumero("01234-5678");

        Telefone telefone2 = new Telefone();
        telefone2.setDdd("11");
        telefone2.setNumero("98765-4321");

        Aluno aluno1 = new Aluno();
        aluno1.setNomeCompleto("Maria da Silva");
        aluno1.setMatricula("0123ABC");
        aluno1.setNascimento(LocalDate.parse("1994-01-01"));
        aluno1.setEmail("mariasilva@mail.com");
        aluno1.setEnderecoList(List.of(endereco1));
        aluno1.setTelefoneList(List.of(telefone1));

        Aluno aluno2 = new Aluno();
        aluno2.setNomeCompleto("José Santos");
        aluno2.setMatricula("654321CBD");
        aluno2.setNascimento(LocalDate.parse("1994-02-02"));
        aluno2.setEmail("josesantos@mail.com");
        aluno2.setEnderecoList(List.of(endereco2));
        aluno2.setTelefoneList(List.of(telefone2));

        // 1) Criando aluno
        alunoModel.create(aluno1);
        alunoModel.create(aluno2);

        // 2) Buscando todos os alunos na base de dados
        List<Aluno> alunos = alunoModel.findAll();
        System.out.println("Qtde de alunos encontrados : " + alunos.size());

        // 3) - Atualizando aluno
        aluno1.setNomeCompleto("Josefina Souza");
        alunoModel.update(aluno1);

        // 4) Buscando aluno por Id
        alunoModel.findById(1L);

        // 5) - Deletando aluno
        alunoModel.delete(aluno1);

        Professor professor1 = new Professor();
        professor1.setNomeCompleto("Carlos José");
        professor1.setMatricula("789456DFG");
        professor1.setEmail("cjose@mail.com");

        MaterialCurso materialCurso1 = new MaterialCurso();
        materialCurso1.setUrl("https://www.meusite.com");

        Curso curso1 = new Curso();
        curso1.setNome("Java JPA");
        curso1.setSigla("JPA");
        curso1.setProfessor(professor1);
        curso1.setMaterial(materialCurso1);
        curso1.setAluno(List.of(aluno1));

        Professor professor2 = new Professor();
        professor2.setNomeCompleto("Cassia Maria");
        professor2.setMatricula("852369LPM");
        professor2.setEmail("cmaria@mail.com");

        MaterialCurso materialCurso2 = new MaterialCurso();
        materialCurso2.setUrl("https://www.meusite2.com");

        Curso curso2 = new Curso();
        curso2.setNome("JavaScript");
        curso2.setSigla("JS");
        curso2.setProfessor(professor2);
        curso2.setMaterial(materialCurso2);
        curso2.setAluno(List.of(aluno2));

        // 1) Criando curso
        cursoModel.create(curso1);
        cursoModel.create(curso2);

        // 2) Buscando todos os cursos na base de dados
        List<Curso> cursos = cursoModel.findAll();
        System.out.println("Qtde de cursos encontrados : " + cursos.size());

        // 3) - Atualizando curso
        curso1.setNome("Java - JPA e Hibernate");
        cursoModel.update(curso1);

        // 4) Buscando curso por Id
        cursoModel.findById(1L);

        // 5) - Deletando curso
        cursoModel.delete(curso1);
    }

}
