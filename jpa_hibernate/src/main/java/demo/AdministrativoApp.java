package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.time.LocalDate;
import java.util.List;

public class AdministrativoApp {

    public static void main(String[] args) {

       //Produto e Pessoa
        ProdutoModel produtoModel = new ProdutoModel();
        PessoaModel pessoaModel = new PessoaModel();

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Matheus");
        pessoa1.setCpf("01234567890");
        pessoa1.setDataNascimento(LocalDate.of(1994, 7, 9));
        pessoa1.setIdade(27);
        pessoa1.setEmail("matheus@mail.com");

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Letícia");
        pessoa2.setCpf("01234567890");
        pessoa2.setDataNascimento(LocalDate.of(1997, 6, 8));
        pessoa2.setIdade(25);
        pessoa2.setEmail("leticia@mail.com");


        // 1) Criando uma pessoa
        pessoaModel.create(pessoa1);
       // pessoaModel.create(pessoa2);

        //2) Buscando todas as pessoas na base de dados
        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontrados : " + pessoas.size());

        //3) Buscando pessoa por id
        pessoa1.setId(1);
        Pessoa pessoa = pessoaModel.findById(pessoa1);
        System.out.println("Pessoa encontrada: " + pessoa.getNome());

        //4) Atualizando uma pessoa
        pessoa2.setEmail("leticia@mail.com");
        pessoaModel.update(pessoa2);

        //5) Deletando uma pessoa
        pessoaModel.delete(pessoa2);

        // --------------

        Produto produto1 = new Produto();
        produto1.setNome("TV");
        produto1.setPreco(300.0);
        produto1.setQuantidade(100);
        produto1.setStatus(true);

        Produto produto2 = new Produto();
        produto2.setNome("NOTEBOOK");
        produto2.setPreco(2000.0);
        produto2.setQuantidade(200);
        produto2.setStatus(true);

        // 1) Criando um produto
        produtoModel.create(produto1);
        produtoModel.create(produto2);

        //2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        //3) Buscando produto por id
        produto1.setId(1);
        Produto produto = produtoModel.findById(produto1);
        System.out.println("Produto encontrado: " + produto.getNome());

        //4) Atualizando um produto
        produto2.setPreco(3000.0);
        produtoModel.update(produto2);

        //5) Deletando um produto
        produtoModel.delete(produto1);
    }
}
