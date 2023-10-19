package org.example.entities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static EntityManagerFactory emf = null;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("gestioneventi");
        } catch (Throwable ex) {
            System.err.println("Initial EntityManagerFactory creation failed " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static void close() {
        emf.close();
    }
}
