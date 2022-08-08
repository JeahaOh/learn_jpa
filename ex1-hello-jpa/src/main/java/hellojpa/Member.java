package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

// @Entity : JPA가 관리할 객체
@Entity
public class Member {
  
  @Id
  // @Id DB PK와 매핑
  private Long id;
  private String name;
  
  public Member() {}
  public Member(Long id, String name) {
    this.id = id;
    this.name = name;
  }
  
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
}