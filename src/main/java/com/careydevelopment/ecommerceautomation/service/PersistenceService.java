package com.careydevelopment.ecommerceautomation.service;

import java.util.List;

public interface PersistenceService<K,E> {

    E save(E entity);
    
    E update(E entity);
 
    void remove(E entity);
 
    E findById(K id);
 
    List<E> findAll();
 
    Long getTotalResult();
}
