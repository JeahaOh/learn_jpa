package hellojpa;

import javax.persistence.*;

// @Entity : JPA가 관리할 객체
@Entity
public class Member {
  
  @Id
  @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long id;
  
  @Column(name ="USERNAME")
  private String username;
  
//  @Column(name = "TEAM_ID")
//  private long teamId;
  @ManyToOne
  @JoinColumn(name = "TEAM_ID")
  private Team team;
  
  public Member() {}
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String name) {
    this.username = name;
  }
  
//  public long getTeamId() { return teamId; }
//  public void setTeamId(long teamId) { this.teamId = teamId; }
  
  public Team getTeam() {
    return team;
  }
  
  public void setTeam(Team team) {
    this.team = team;
  }
  public void changeTeam(Team team) {
    this.team = team;
    // 연관관계 편의를 고려
    // 이 외의 방어 코드등 처리 로직이 들어가야 함
    team.getMembers().add(this);
  }
}
