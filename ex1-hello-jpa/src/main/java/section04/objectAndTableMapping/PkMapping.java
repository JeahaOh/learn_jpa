package section04.objectAndTableMapping;

import javax.persistence.*;

@Entity
@Table(name = "PK_MAPPING")
@SequenceGenerator(
        name = "PK_MAPPING_SEQ_GEN",
        sequenceName = "TEST_SEQ",
        initialValue = 1, allocationSize = 1
)
public class PkMapping {
  
  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
  
      PkMapping mbr = new PkMapping();
      mbr.setName("A");
      
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