/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cauã
 */
public class CursoDao extends GenericDao<Curso> implements CursoIDao{
    

 private static EntityManagerFactory emf; 

    static {
        try {
            emf = Persistence.createEntityManagerFactory("Gerenciamento de Curso"); 
        } catch (Exception e) {
            // Tratamento de erro inicial, a aplicação provavelmente não funcionará
            e.printStackTrace();
            throw new RuntimeException("Falha na inicialização da fábrica de EntityManager.", e);
        }
    }

    // 2. Este método 'protected' cria um NOVO EntityManager a partir da fábrica
    // Ele é chamado a cada operação
    protected EntityManager getEntityManager() {
        return emf.createEntityManager(); 
    }

    // 3. EXEMPLO de uso no findbyName (ou qualquer outro método DAO)
 @Override
    public List<Curso> findbyName(String nomeBuscado) {
        EntityManager em = null; // Declare aqui, inicialize como null
        List<Curso> cursos = new ArrayList<>(); // Inicialize para garantir que nunca seja null
        try {
            em = getEntityManager(); // <-- OBTÉM UM NOVO EntityManager
            // ... sua lógica de JPQL ...
            TypedQuery<Curso> query = em.createQuery(
                "SELECT c FROM Curso c WHERE LOWER(c.nome) LIKE :nomeBusca ORDER BY c.nome", Curso.class);
            query.setParameter("nomeBusca", "%" + nomeBuscado.toLowerCase() + "%");
            cursos = query.getResultList();
        } catch (Exception e) {
            // Log do erro
            e.printStackTrace();
            throw e; // Ou outra forma de tratar o erro
        } finally {
            // 4. SEMPRE FECHE O EntityManager no bloco finally!
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return cursos;
    }
}
        