package pers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("notizPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();



        Notiz not1 = new Notiz("butter","blabla");


        entityManager.persist(not1);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();

    }}
