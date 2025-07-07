/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

import br.com.ifba.curso.entity.Curso;

/**
 *
 * @author Cauã
 */
public class StringUtil {
    
    public String comparaCurso(Curso curso1,Curso curso2){
        
        if(curso1.getNome().equals(curso2.getNome())){
            
            return "Esse curso ja existe";
        }
        return "";
    }
}
