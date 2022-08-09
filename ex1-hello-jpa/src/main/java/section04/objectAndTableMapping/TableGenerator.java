package section04.objectAndTableMapping;

import javax.persistence.*;

@Entity
@javax.persistence.TableGenerator(
        name = "SEQ_GEN",
        table = "SEQ",
        pkColumnValue = "MEM_SEQ", allocationSize = 1
)
public class TableGenerator {
  
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQ_GEN")
  private Long id;
  
  private String name;
  
  public TableGenerator() {}
  
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
  
      TableGenerator seq = new TableGenerator();
      seq.setName("A");
      
      em.persist(seq);
      
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    
    emf.close();
  }
}
