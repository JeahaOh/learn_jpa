package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    
    try {
      // 저
      Team team = new Team();
      team.setName("TeamA");
      em.persist(team);
      
      Member member1 = new Member();
      member1.setUsername("member 1");
      // member1.setTeamId(team.getId());
      member1.setTeam(team);
      em.persist(member1);
  
      em.flush();
      
      Member findMember = em.find(Member.class, member1.getId());
      
      // Long findTeamId = findMember.getTeamId();
      // Team findTeam = em.find(Team.class, findTeamId);
      Team findTeam = member1.getTeam();
      System.out.println("findTeam = " + findTeam.getName());
      
      Team newTeam = new Team();
      newTeam.setName("newTeam");
      em.persist(newTeam);
      
      findMember.setTeam(newTeam);
      em.persist(findMember);
      em.flush();
      System.out.println("findTeam = " + findMember.getTeam().getName());
      
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    
    emf.close();
  }
}
