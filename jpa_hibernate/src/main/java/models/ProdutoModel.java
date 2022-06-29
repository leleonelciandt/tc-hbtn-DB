package models;

import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoModel {


    public void create(Produto p) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            System.out.println("Iniciando a transação - Criando!");
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar produto !!!" + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação - Criado!");
        }
    }

    public void update(Produto p) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();


        try {
            Produto produto = em.find(Produto.class, p.getId());
            em.getTransaction().begin();
            System.out.println("Iniciando a transação - Atualizando!");
            em.merge(produto);
            em.getTransaction().commit();
            System.out.println("Produto atualizado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar produto !!!" + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            Produto produto = em.find(Produto.class, p.getId());
            em.getTransaction().begin();
            System.out.println("Iniciando a transação - Deletando! ");
            em.remove(produto);
            em.getTransaction().commit();
            System.out.println("Produto removido com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao remover produto !!!" + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Produto findById(Produto p) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        Produto produtoId = null;

        try {
            em.getTransaction().begin();
            System.out.println("Iniciando a transação - Encontrando por Id!");
            produtoId = em.find(Produto.class, p.getId());
            System.out.println("Produto encontrado com sucesso, id:" + produtoId);
            return produtoId;
        } catch (Exception e) {
            System.err.println("Erro ao buscar a produto com id:" + produtoId);
            return null;
        } finally {
            em.close();
            em.close();
            System.out.println("Finalizando a transação");
        }

    }

    public List<Produto> findAll() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();



        try {
            em.getTransaction().begin();
            System.out.println("Iniciando a transação - Encontrando todos os produtos!");
            List<Produto> produtos = em.createNativeQuery("SELECT * FROM Produto", Produto.class).getResultList();
            em.getTransaction().commit();
            return produtos;
        } catch (Exception e) {
            System.err.println("Erro ao buscar produtos !!!" + e.getMessage());
            return null;
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }

    }
}

