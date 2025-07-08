/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.util.StringUtil;
import java.util.List;

/**
 *
 * @author Cauã
 */
public class CursoService implements CursoIService{
    
    private final CursoIDao cursoDao = new CursoDao();

    public CursoService() {
    }
   // o objetivo desses meetodos é validar os dados e a acao e passar para o dao
    
   
    @Override
    public Curso save(Curso curso) throws RuntimeException {
      
        if( StringUtil.estaEmBranco(curso.getNome()) ){ // utilizacao das verifificoes da classe String Util é repetida em todos os metodos
            throw new RuntimeException("Dados do Curso nao preenchidos");
            
        }else if (curso.getId() != null ){
            throw new RuntimeException("Curso"+ "ja existente no banco de dados");
      }else{
       return cursoDao.Save(curso);
        }    

    }

    @Override
    public Curso update(Curso curso)throws RuntimeException {
        
        if(StringUtil.ehNull(curso)){
            throw new RuntimeException("Dados do Curso nao preenchidos");
            
        } else {
        return cursoDao.Update(curso);
        }
    }

    @Override
    public void delete(Curso curso)throws RuntimeException {
        
      if(StringUtil.ehNull(curso)){
            throw new RuntimeException("Esse curso nao existe");
            
        } else {
       cursoDao.Delete(curso);
        }
    }
    
    @Override
    public List<Curso> findAll() throws RuntimeException{
  
        return cursoDao.findAll();
    }

    @Override
    public Curso findById(Long id) throws RuntimeException{
         if(StringUtil.idNull(id)){
            throw new RuntimeException("Esse curso nao existe");
            
        }else{
       return   cursoDao.findById(id);
         }
    }

    @Override
    public List<Curso> findByNome(String nome) throws RuntimeException{
          if(StringUtil.estaVazia(nome)||StringUtil.estaEmBranco(nome)){
            throw new RuntimeException("Esse curso nao existe");
            
        }else{
         return cursoDao.findbyName(nome);
         }
    }
    
}
