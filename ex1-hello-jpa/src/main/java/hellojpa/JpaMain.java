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
      // 저장
      Team team = new Team();
      team.setName("TeamA");
      em.persist(team);
      
      Member member = new Member();
      member.setUsername("member 1");
      member.setTeam(team);
      em.persist(member);
      
      for (int i = 2; i <= 10; i++) {
        member = new Member();
        member.setUsername("member " + i);
        member.setTeam(team);
        em.persist(member);
      }
  
      em.flush();
      em.clear();
      
      Member findMember = em.find(Member.class, member.getId());
      List<Member> members = findMember.getTeam().getMembers();
      System.out.println("members : " + members.size());
      
      
      System.out.println("=".repeat(30));
      for (Member findFromMembers : members) {
         System.out.println("M = " + findFromMembers.getUsername());
      }
      System.out.println("=".repeat(30));
      
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    
    emf.close();
  }
}
