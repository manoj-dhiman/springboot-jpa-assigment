package com.assignment.springboot.assignementboot.repository;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJpaDAO<T extends Serializable> {
  private Class<T> clazz;

  @PersistenceContext protected EntityManager entityManager;

  public void setClazz(Class<T> clazzToSet) {
    this.clazz = clazzToSet;
  }

  public T findOne(Long id) {
    return entityManager.find(clazz, id);
  }

  public T findOne(int id) {
    return entityManager.find(clazz, id);
  }

  public List<T> findAll() {
    return (List<T>) entityManager.createQuery("FROM " + clazz.getName(), clazz).getResultList();
  }

  public T save(T entity) {
    entityManager.persist(entity);
    return entity;
  }

  public T update(T entity) {
    return entityManager.merge(entity);
  }

  public void flush() {
    entityManager.flush();
  }

  public void clear() {
    entityManager.clear();
  }
}
