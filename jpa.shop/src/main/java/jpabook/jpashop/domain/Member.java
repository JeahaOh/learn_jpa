package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
  
  @Id @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long id;
  private String name;
  private String city;
  private String street;
  private String zipcode;
  
  // member를 보고 member의 order를 조회할 필요가 있을까?
  // 생각해 보면 비지니스간의 관계는 끊어주는 게 깔끔하다.
  @OneToMany(mappedBy = "member")
  private List<Order> orders = new ArrayList<>();
  
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
  
  public String getCity() {
    return city;
  }
  
  public void setCity(String city) {
    this.city = city;
  }
  
  public String getStreet() {
    return street;
  }
  
  public void setStreet(String street) {
    this.street = street;
  }
  
  public String getZipcode() {
    return zipcode;
  }
  
  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }
}
