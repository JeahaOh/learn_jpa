package section04.objectAndTableMapping;

import javax.persistence.*;

@Entity
@Table(name = "IDNTT_MMBR")
public class IdentityStrategyMmbr {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "name", nullable = false)
  private String name;
  
  public IdentityStrategyMmbr() {}
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    
    try {
  
      IdentityStrategyMmbr mbr = new IdentityStrategyMmbr();
      mbr.setName("A");
  
      System.out.println("-".repeat(10));
      em.persist(mbr);
      System.out.println("-".repeat(10));
      
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    
    emf.close();
  }
}