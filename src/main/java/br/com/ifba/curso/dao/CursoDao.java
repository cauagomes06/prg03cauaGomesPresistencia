/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cauã
 */
@Repository
public class CursoDao extends GenericDao<Curso> implements CursoIDao{
    
 @Override
    public List<Curso> findbyName(String nomeBuscado) {
        List<Curso> cursos = new ArrayList<>(); // Inicialize para garantir que nunca seja null
        try {
            // ... sua lógica de JPQL ...
            TypedQuery<Curso> query = entityManager.createQuery(
                "SELECT c FROM Curso c WHERE LOWER(c.nome) LIKE :nomeBusca ORDER BY c.nome", Curso.class);
            query.setParameter("nomeBusca", "%" + nomeBuscado.toLowerCase() + "%");
            cursos = query.getResultList();
        } catch (Exception e) {
            // Log do erro
            e.printStackTrace();
            throw e; // Ou outra forma de tratar o erro
        } 
        return cursos;
    }
}
        