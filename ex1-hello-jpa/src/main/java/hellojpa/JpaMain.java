package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    
    try {
      Movie movie = new Movie();
      movie.setDirector("aaaa");
      movie.setActor("bbb");
      movie.setName("Gone");
      movie.setPrice(10000);
      
      em.persist(movie);
      
      em.flush();
      em.clear();
      
      Movie findMovie = em.find(Movie.class, movie.getId());
      System.out.println("find MOVIE : " + findMovie);
  
      em.flush();
      em.clear();
  
      // item을 abstract로 할 경우 union query를 날림;
      Item findItem = em.find(Item.class, movie.getId());
      System.out.println("find ITEM : " + findItem);
      
      
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    
    emf.close();
  }
}
