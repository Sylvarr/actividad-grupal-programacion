package test.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestConexion {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectosFP");
        EntityManager em = emf.createEntityManager();
        System.out.println("Conexión OK: " + em.isOpen());
        em.close();
        emf.close();
    }
}