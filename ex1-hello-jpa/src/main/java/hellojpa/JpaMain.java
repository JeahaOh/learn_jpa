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
      // 양방향 매핑시 가장 많이 하는 실수 1
      // 연관관계의 주인에 값을 입력하지 않음
      Member memberA = new Member();
      memberA.setUsername("member 1");
      em.persist(memberA);
      
      Team teamA = new Team();
      teamA.setName("TeamA");
      // 역방향(주인이 아닌 방향)만 연관관계 설정
      teamA.getMembers().add(memberA);
      em.persist(teamA);
  
      em.flush();
      em.clear();
      
      // 양방향 매핑시 가장 많이하는 실수 2
      Team teamB = new Team();
      teamB.setName("Team B");
      em.persist(teamB);
      
      Member memberB = new Member();
      memberB.setUsername("member b");
      //memberB.setTeam(teamB);
      memberB.changeTeam(teamB);
      em.persist(memberB);
      
      // 양방향으로 값을 다 셋팅 해 줘야 함
      //teamB.getMembers().add(memberB);
      
      // em.flush();
      // em.clear();
      
      // 1차 캐시
      Team findTeam = em.find(Team.class, teamB.getId());
      List<Member> membersB = findTeam.getMembers();
      
      System.out.println("-".repeat(20));
      for (Member m : membersB) {
        System.out.println("m : " + m.getUsername());
      }
      System.out.println("-".repeat(20));
      
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    
    emf.close();
  }
}
