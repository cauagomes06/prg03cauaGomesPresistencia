/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cauã
 * @param <Entity>
 */
@SuppressWarnings("unchecked")

@Repository
public class GenericDao <Entity extends PersistenceEntity> 
        implements GenericIDao<Entity> {
    
    @PersistenceContext
    protected  EntityManager entityManager;


    @Override
    @Transactional
    public Entity Save(Entity entity){

        entityManager.persist(entity);
        return entity;
    }
    @Override
    @Transactional
    public Entity Update (Entity entity){
        
 
        entityManager.merge(entity);

        return entity;
    }
    @Override
    @Transactional
    public void Delete (Entity entity){
        entity = findById(entity.getId());

        entityManager.remove(entity);

   
    }
    @Override
    @Transactional(readOnly = true)
    public List<Entity> findAll(){
        
        TypedQuery<Entity> query = (TypedQuery<Entity>) entityManager.createQuery("FROM " + getTypeClass().getName(), getTypeClass());
        return query.getResultList();
    }
    
    
    @Override
    public Entity findById(Long id){
        
        
        return (Entity)entityManager.find(getTypeClass(),id);
    }
    
    
    protected Class<?> getTypeClass() {
    Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    return clazz;
    }
}
