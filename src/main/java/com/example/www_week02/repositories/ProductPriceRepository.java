package com.example.www_week02.repositories;

import com.example.www_week02.models.Product;
import com.example.www_week02.models.ProductPrice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDateTime;
import java.util.Optional;

public class ProductPriceRepository extends  CRUDRepository<ProductPrice>{

    public ProductPriceRepository() {
    }

    @Override
    public void setType(Class<ProductPrice> type) {
        super.setType(type);
    }
    public Optional<ProductPrice> findByProductId(Long productId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            Optional<ProductPrice> optionalProductPrice = Optional.of(
                    em.createNamedQuery("findByProductId", ProductPrice.class).
                            setParameter(1, productId).
                            getSingleResult());
            tr.commit();
            return optionalProductPrice;
        } catch (Exception e) {
            tr.rollback();
            throw new RuntimeException(e);
        }
    }
    public boolean updatePrice(Long id, double price){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        try {
            if(!tr.isActive()){
                tr.begin();
            }
            Product product = em.find(Product.class, id);
            if(product == null){
                return false;
            }
            ProductPrice productPrice = new ProductPrice();
            productPrice.setProduct(product);
            LocalDateTime time = LocalDateTime.now();
            productPrice.setPrice_date_time(time); // now, price time is joda datetime
            productPrice.setPrice(price);
            em.persist(productPrice);
            tr.commit();
            return true;
        }catch (Exception e){
            tr.rollback();
            throw  new RuntimeException(e.getMessage());
        }
    }
}
