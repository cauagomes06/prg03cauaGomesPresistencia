/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;


import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.repository.CursoRepository;
import br.com.ifba.infrastructure.util.StringUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cauã
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CursoService implements CursoIService{

    private final CursoRepository cursoRepository;

   // o bjetivo desses metodos é validar os dados e a acao e passar para o dao
    
    @Override
    public Curso save(Curso curso) throws RuntimeException {
      
        if( StringUtil.estaEmBranco(curso.getNome()) ){ // utilizacao das verifificoes da classe String Util é repetida em todos os metodos
            throw new RuntimeException("Dados do Curso nao preenchidos");
            
        }else if (curso.getId() != null ){
            throw new RuntimeException("Curso"+ "ja existente no banco de dados");
      }else{
              log.info(" Salvando curso"); // log
       return cursoRepository.save(curso);
        }    

    }

    @Override
    public Curso update(Curso curso)throws RuntimeException {
        
        if(StringUtil.ehNull(curso)){
            throw new RuntimeException("Dados do Curso nao preenchidos");
            
        } else {
               log.info(" Editando Curso");//log
        return cursoRepository.save(curso);
        }
    }

    @Override
    public void delete(Curso curso)throws RuntimeException {
        
      if(StringUtil.ehNull(curso)){
            throw new RuntimeException("Esse curso nao existe");
            
        } else {
          log.info(" Deletando Curso");//log
          cursoRepository.delete(curso);
        }
    }
    
    @Override
    public List<Curso> findAll() throws RuntimeException{

        return cursoRepository.findAll();
    }

    @Override
    public Curso findById(Long id) throws RuntimeException{
         if(StringUtil.idNull(id)){
            throw new RuntimeException("Esse curso nao existe");
            
        }else{
       return   cursoRepository.findById(id).orElseThrow(()-> {
           return new RuntimeException("Curso de id : "+id+" nao encontrado");
       });
         }
    }

    @Override
    public List<Curso> findByNome(String nome) throws RuntimeException{
          if(StringUtil.estaVazia(nome)||StringUtil.estaEmBranco(nome)){
            throw new RuntimeException("Esse curso nao existe");
            
        }else{
         return cursoRepository.findByNome(nome);
         }
    }
    
}
