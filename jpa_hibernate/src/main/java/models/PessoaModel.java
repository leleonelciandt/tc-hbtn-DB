package models;

import entities.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PessoaModel {


    public void create(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            System.out.println("Iniciando a transação - Criando!");
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao criar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            Pessoa pessoa = em.find(Pessoa.class, p.getId());
            em.getTransaction().begin();
            System.out.println("Iniciando a transação - Atualizando!");
            em.merge(pessoa);
            em.getTransaction().commit();
            System.out.println("Pessoa atualizada com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            Pessoa pessoa = em.find(Pessoa.class, p.getId());

            System.out.println("Iniciando a transação - Deletando!");
            em.getTransaction().begin();
            em.remove(pessoa);
            em.getTransaction().commit();
            System.out.println("Pessoa removida com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao remover a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Pessoa findById(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        Pessoa pessoaId = null;

        try {
            System.out.println("Iniciando a transação - Encontrando!");
            em.getTransaction().begin();
            pessoaId = em.find(Pessoa.class, p.getId());
            System.out.println("Pessoa encontrada com sucesso, id:" + pessoaId);
            return pessoaId;
        } catch (Exception e) {
            System.err.println("Erro ao buscar a pessoa com id:" + pessoaId);
            return null;
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }

    }

    public List<Pessoa> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();


        try {
            System.out.println("Iniciando a transação - Encontrando Todos!");
            List<Pessoa> pessoas = em.createNativeQuery("SELECT * FROM Pessoa", Pessoa.class).getResultList();
            return pessoas;
        } catch (Exception e) {
            System.err.println("Erro ao buscar pessoas !!!" + e.getMessage());
            return null;
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }

    }
}