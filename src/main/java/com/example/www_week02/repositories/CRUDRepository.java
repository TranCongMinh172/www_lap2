package com.example.www_week02.repositories;

import com.example.www_week02.connect.Connection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class CRUDRepository<T> {
    protected EntityManagerFactory emf;
    protected  Class<T> type;

    public CRUDRepository() {
        emf = Connection.getInstance().getEntityManagerFactory();
    }

    public void setType(Class<T> type) {
        this.type = type;
    }
    public  boolean insert(T t){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

       try {
           et.begin();
           em.persist(t);
           et.commit();
           em.close();
           return  true;
       }catch (Exception e){
            et.rollback();
            throw new RuntimeException(e);
       }
    }

    public boolean update(T t ){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et  = em.getTransaction();
        try {
            et.begin();
            em.merge(t);
            et.commit();
            em.close();
            return  true;

        }catch (Exception e){
            et.rollback();
            throw  new RuntimeException(e);
        }
    }


    public List<T> getListResult(String className){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        List<T> tList;
        try {
            et.begin();
            tList = em.createNativeQuery("select*from   " +className,type).getResultList();
            et.commit();
            em.close();
        }catch (Exception e){
            et.rollback();
            throw new RuntimeException(e);
        }
        return  tList;

    }

    public Optional<T> findById(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            T t = em.find(type,id);
            et.commit();
            em.close();
            return  t == null ? Optional.empty() : Optional.of(t);
        }catch (Exception e){
            et.rollback();
            throw new RuntimeException(e);
        }
    }
}
