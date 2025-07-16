/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import java.util.List;

/**
 *
 * @author Cauã
 */
//interface da camada controladora da arquitetura aqui tem todos os metodos abstract que serao aplicados na classe controller
public interface CursoIController {
    
      public abstract Curso save(Curso curso);
      
      public abstract Curso update(Curso curso);
        
      public abstract void delete(Curso curso);   

      public abstract List<Curso> findAll();

      public abstract Curso findById(Long id);
 
      public abstract List<Curso> findByNome(String nome) ;
    
}
