package section04.objectAndTableMapping;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

//@Entity
//@Table(name = "MBR")
public class Mmbr {
  
  @Id
  private Long id;
  
  // DDL 생성 기능, ddl에만 영향을 주고 로직에는 영향없
  @Column(length = 10, name="name", updatable = false, columnDefinition = "varchar(100) default 'EMPTY'")
  private String username;
  
  @Column(insertable = true , nullable = false)
  private Integer age;
  
  @Enumerated(EnumType.STRING)
  //@Enumerated
  private RoleType roleType;
  
  @Temporal(TemporalType.TIMESTAMP)
  private Date createDate;
  
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastModifiedDate;
  
  private LocalDate localDate;
  private LocalDateTime localDateTime;
  
  @Lob
  private String description;
  
  @Transient
  private int temp;
  
  public Mmbr() {}
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public Integer getAge() {
    return age;
  }
  
  public void setAge(Integer age) {
    this.age = age;
  }
  
  public RoleType getRoleType() {
    return roleType;
  }
  
  public void setRoleType(RoleType roleType) {
    this.roleType = roleType;
  }
  
  public Date getCreateDate() {
    return createDate;
  }
  
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  
  public Date getLastModifiedDate() {
    return lastModifiedDate;
  }
  
  public void setLastModifiedDate(Date lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public int getTemp() {
    return temp;
  }
  
  public void setTemp(int temp) {
    this.temp = temp;
  }
}
