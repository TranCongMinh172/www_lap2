package com.example.www_week02.repositories;

import com.example.www_week02.enums.ProductStatus;
import com.example.www_week02.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class ProductRepository extends  CRUDRepository<Product>{
    public ProductRepository() {
    }

    @Override
    public void setType(Class<Product> type) {
        super.setType(type);
    }
    public boolean delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            if(!tr.isActive()){
                tr.begin();
            }
            Product product = em.find(Product.class, id);
            if(product==null)
                return false;
            if(product.getStatus()== ProductStatus.TERMINATED){
                return false;
            }
            product.setStatus(ProductStatus.TERMINATED);
            em.merge(product);
            tr.commit();
            return true;
        }catch (Exception e){
            tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<Product> getAllActiveProduct(int status){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        List<Product> products;
        try {
            tr.begin();
            products = em.createNamedQuery("getAllActiveProduct",Product.class).setParameter(1,status).getResultList();
            tr.commit();
            return products;
        }catch (Exception e){
            tr.rollback();
            throw new RuntimeException(e) ;
        }
    }

}
