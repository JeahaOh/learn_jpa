package section04.objectAndTableMapping;

import javax.persistence.*;

//@Entity
@Table(name = "PK_MAPPING")
@SequenceGenerator(
        name = "PK_MAPPING_SEQ_GEN",
        sequenceName = "TEST_SEQ",
        initialValue = 1, allocationSize = 50
)
public class PkMapping {
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "PK_MAPPING_SEQ_GEN"
  )
  private Long id;
  
  private String name;
  
  public PkMapping() {}
  
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
  
      PkMapping mbrA = new PkMapping();
      mbrA.setName("A");
      
      PkMapping mbrB = new PkMapping();
      mbrB.setName("B");
      
      PkMapping mbrC = new PkMapping();
      mbrC.setName("C");
      
      System.out.println("-".repeat(100));
      
      em.persist(mbrA); // 1, 51
      em.persist(mbrB); // MEM
      em.persist(mbrC); // MEM
      
      System.out.println("mbrA = " + mbrA.getId());
      System.out.println("mbrB = " + mbrB.getId());
      System.out.println("mbrC = " + mbrC.getId());
  
      System.out.println("-".repeat(100));
      
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    
    emf.close();
  }
}