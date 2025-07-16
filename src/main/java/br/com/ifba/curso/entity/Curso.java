/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author Cauã
 */

@Entity
@Table(name = "CURSOS")// cria a tabela no banco
public class Curso extends PersistenceEntity 
        implements Serializable {
 @Id //id como chave primaria
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
  // criacao das colunas
   @Column(name = "NOME", nullable = false,length = 255)
    private String nome;
 
   @Column(name = "CODIGO", nullable = false,length = 255)
    private String codigoCurso;
  
   @Column(name = "ATIVO", nullable = false)
    private boolean ativo;

    public Curso() {

    }
//setters e getters a seguir
 @Override
    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

 @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

  
     public boolean isAtivoNoParamenter() {
        return ativo;
    }
}
