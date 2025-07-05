/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Entity;
import java.util.List;

/**
 *
 * @author Cauã
 */
public interface GenericIDao<Entity extends PersistenceEntity>{
    
    // metodos abstratos que serao usados no genericDao
    public abstract Entity Save (Entity obj);

    public abstract Entity Update (Entity obj);
    
    public abstract void Delete (Entity obj);
    
    public abstract List<Entity> findAll();
    
    public abstract Entity findById(Long id);
}
