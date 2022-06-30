package models;

import entities.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CursoModel {


    public void create(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            System.out.println("Iniciando a transação - Criando!");
            em.persist(curso);
            em.getTransaction().commit();
            System.out.println("Curso criado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao criar um curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Curso findById(Long id) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();


        try {
            em.getTransaction().begin();
            System.out.println("Iniciando a transação - Encontrando!");
            Curso cursoId = em.find(Curso.class, id);
            System.out.println("Aluno encontrada com sucesso, id:" + cursoId);
            return cursoId;
        } catch (Exception e) {
            System.err.println("Erro ao buscar curso com id:" + id);
            return null;
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }

    public List<Curso> findAll() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();


        try {
            System.out.println("Iniciando a transação - Encontrando Todos!");
            List cursos = em.createNativeQuery("SELECT * FROM Curso", Curso.class).getResultList();
            return cursos;
        } catch (Exception e) {
            System.err.println("Erro ao buscar cursos !!!" + e.getMessage());
            return null;
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Curso curso) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            Curso cursoToUpdate = em.find(Curso.class, curso.getId());
            em.getTransaction().begin();
            System.out.println("Iniciando a transação - Atualizando!");
            em.merge(cursoToUpdate);
            em.getTransaction().commit();
            System.out.println("Curso atualizada com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar curso !!!" + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }    }

    public void delete(Curso curso) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            Curso cursoToDelete = em.find(Curso.class, curso.getId());
            em.getTransaction().begin();
            System.out.println("Iniciando a transação - Deletando!");
            em.remove(cursoToDelete);
            em.getTransaction().commit();
            System.out.println("Curso removida com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao remover o curso !!!" + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }


}
