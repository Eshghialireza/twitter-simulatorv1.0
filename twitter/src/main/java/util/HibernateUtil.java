package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("twitter");
    private static EntityManager em = null;

    private HibernateUtil() {

    }

    public static EntityManager getEm() {
        if (em == null)
            em = emf.createEntityManager();
        return em;
    }
}
