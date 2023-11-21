package com.example.www_week02.connect;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {
    private static  Connection instance;
    private EntityManagerFactory entityManagerFactory;

    public Connection() {
        entityManagerFactory = Persistence.createEntityManagerFactory("week02");
    }

    public static Connection getInstance() {
        if(instance == null){
            instance = new Connection();
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Connection.getInstance().getEntityManagerFactory();
        System.out.println(emf);
    }
}
