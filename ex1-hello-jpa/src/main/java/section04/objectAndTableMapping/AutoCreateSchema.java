package section04.objectAndTableMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AutoCreateSchema {
  
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    
    try {
      
      Mmbr mbr = new Mmbr();
      mbr.setId(3L);
      mbr.setUsername("C");
      mbr.setAge(30);
      mbr.setRoleType(RoleType.GUEST);
      
      em.persist(mbr);
     
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    
    emf.close();
  }
}