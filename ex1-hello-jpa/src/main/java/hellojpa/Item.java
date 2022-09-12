package hellojpa;

import javax.persistence.*;

@Entity
// 상속에 대한 테이블 설계를 어떻게 할것인지 정함
//@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // table per class 할 경우 abstract class로
@DiscriminatorColumn
public abstract class Item {
  
  @Id @GeneratedValue
  private long id;

  private String name;
  private int price;
  
  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getPrice() {
    return price;
  }
  
  public void setPrice(int price) {
    this.price = price;
  }
}
