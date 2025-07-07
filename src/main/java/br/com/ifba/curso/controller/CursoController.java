/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import br.com.ifba.curso.service.CursoService;
import java.util.List;

/**
 *
 * @author Cauã
 */
public class CursoController implements CursoIController {
    
    
    private final CursoIService cursoIService = new CursoService(); 
    
    @Override
    public  List<Curso> findAll() throws RunTimeException{
        
        return cursoIService.findAll();
    }
    
    @Override
    public  Curso save(Curso curso)throws RunTimeException{
        
        return cursoIService.save(curso);
    }
    
    @Override
    public Curso update(Curso curso)throws RunTimeException{
        
       return cursoIService.update(curso);
    }
    
    @Override
    public  void delete (Curso curso)throws RunTimeException{
        cursoIService.delete(curso);
    }
    
    @Override
    public  Curso findById(Long id)throws RunTimeException{
        
        return cursoIService.findById(id);
    }
    
    @Override
    public  List<Curso> findByNome(String nome)throws RunTimeException{
        return cursoIService.findByNome(nome);
    }
}
