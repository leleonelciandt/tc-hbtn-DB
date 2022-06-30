package models;

import entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AlunoModel {

    public void create(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            System.out.println("Iniciando a transação - Criando!");
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao criar um aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Aluno findById(Long id) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();


        try {
            em.getTransaction().begin();
            System.out.println("Iniciando a transação - Encontrando!");
            Aluno alunoId = em.find(Aluno.class, id);
            System.out.println("Aluno encontrada com sucesso, id:" + alunoId);
            return alunoId;
        } catch (Exception e) {
            System.err.println("Erro ao buscar aluno com id:" + id);
            return null;
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }

    public List<Aluno> findAll() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();


        try {
            System.out.println("Iniciando a transação - Encontrando Todos!");
            List<Aluno> alunos = em.createNativeQuery("SELECT * FROM Aluno", Aluno.class).getResultList();
            return alunos;
        } catch (Exception e) {
            System.err.println("Erro ao buscar alunos !!!" + e.getMessage());
            return null;
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Aluno aluno) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            Aluno alunoToUpdate = em.find(Aluno.class, aluno.getId());
            em.getTransaction().begin();
            System.out.println("Iniciando a transação - Atualizando!");
            em.merge(alunoToUpdate);
            em.getTransaction().commit();
            System.out.println("Aluno atualizada com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar aluno !!!" + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }    }

    public void delete(Aluno aluno) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            Aluno alunoToDelete = em.find(Aluno.class, aluno.getId());
            em.getTransaction().begin();
            System.out.println("Iniciando a transação - Deletando!");
            em.remove(alunoToDelete);
            em.getTransaction().commit();
            System.out.println("Aluno removida com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao remover o aluno !!!" + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }

}
