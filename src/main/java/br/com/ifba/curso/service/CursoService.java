/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;

import java.util.List;

/**
 *
 * @author Cauã
 */
public class CursoService implements CursoIService{
    
    private final CursoIDao cursoDao = new CursoDao();

    public CursoService() {
    }

    @Override
    public Curso save(Curso curso) throws RunTimeException {
      
        if(curso == null){
            throw new RunTimeException("Dados do Curso nao preenchidos");
            
        }else if (curso.getId() != null ){
            throw new RunTimeException("Curso"+ "ja existente no banco de dados");
      }else{
       return cursoDao.Save(curso);
        }    

    }

    @Override
    public Curso update(Curso curso)throws RunTimeException {
        
        if(curso == null){
            throw new RunTimeException("Dados do Curso nao preenchidos");
            
        } else {
        return cursoDao.Update(curso);
        }
    }

    @Override
    public void delete(Curso curso)throws RunTimeException {
        
      if(curso == null){
            throw new RunTimeException("Esse curso nao existe");
            
        } else {
       cursoDao.Delete(curso);
        }
    }
    
    @Override
    public List<Curso> findAll() throws RunTimeException{
  
        return cursoDao.findAll();
    }

    @Override
    public Curso findById(Long id) throws RunTimeException{
         if(id == null){
            throw new RunTimeException("Esse curso nao existe");
            
        }else{
       return   cursoDao.findById(id);
         }
    }

    @Override
    public List<Curso> findByNome(String nome) throws RunTimeException{
          if(nome == null){
            throw new RunTimeException("Esse curso nao existe");
            
        }else{
         return cursoDao.findbyName(nome);
         }
    }
    
}
