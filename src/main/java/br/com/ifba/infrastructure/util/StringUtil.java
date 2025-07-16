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
      
      public static boolean estaVazia(String str) {
        return str == null || str.isEmpty();
    }
      public static boolean estaEmBranco(String str) {
        return str == null || str.trim().isEmpty();
    }
      public static boolean ehNull(Object obj){
          return obj == null;
      }
      public static boolean idNull(Long id){
          return id == null;
      }
      
}
