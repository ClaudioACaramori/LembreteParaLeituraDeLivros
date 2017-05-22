package persistencia.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by claud on 22/05/2017.
 */
public class EntityManagerFactory {
    static EntityManager entityManager;

    public static EntityManager getEntityManager(){
        if (entityManager == null){
            javax.persistence.EntityManagerFactory emf =  Persistence.createEntityManagerFactory("testejera");
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }
}
