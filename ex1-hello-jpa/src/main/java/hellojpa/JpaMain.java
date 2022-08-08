package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
  public static void main(String[] args) {
    // 하나만 생성해서 어플리케이션 전체에서 공유
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    // 쓰레드간 공유 X (사용하고 버려야 함)
    EntityManager em = emf.createEntityManager();
    
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    
    /*
    try {
      Member member = new Member();
      member.setId(3L);
      member.setName("hello3");
      em.persist(member);
      
      tx.commit();
    } catch (Exception e){
      tx.rollback();
    } finally {
      em.close();
    }
    */
    
    /*
    try {
      Member findMember = em.find(Member.class, 1L);
      System.out.println("findMember.id = " + findMember.getId());
      System.out.println("findMember.name = " + findMember.getName());
    
      tx.commit();
    } catch (Exception e){
      tx.rollback();
    } finally {
      em.close();
    }
    */
    
    /*
    try {
      Member findMember = em.find(Member.class, 1L);
      
      findMember.setName("helloJPA");
      System.out.println("findMember.id = " + findMember.getId());
      System.out.println("findMember.name = " + findMember.getName());
    
      tx.commit();
    } catch (Exception e){
      tx.rollback();
    } finally {
      em.close();
    }
    */
  
    /*
    try {
      Member findMember = em.find(Member.class, 3L);
      em.remove(findMember);
    
      tx.commit();
    } catch (Exception e){
      tx.rollback();
    } finally {
      em.close();
    }
    */
    
    try {
      /**
       * JPQL
       * jpa는 sql을 추상화한 jpql이라는 객체 지향 쿼리 언어를 제공함
       * sql과 문법 유사, select, from, where, group by, having, join 지원
       * jpql은 entity 객체를 대상으로 쿼리 수행
       * sql은 db table을 대상으로 쿼리 수행
       * 테이블이 아닌 객체를 대상으로 검색하는 객체지향 쿼리
       * sql을 추상화하여 특정 DB에 종속성 X
       * jpql === 객체지향 sql
       *
       * 이후 등장한 query dsl을 사용하면 java로 거의 모든 qeury 수행 가능
       */
      List<Member> result = em.createQuery("select m from Member as m", Member.class)
              // pagination
              // 5번부터
              .setFirstResult(5)
              // 10개
              .setMaxResults(10)
              .getResultList();
      
      for (Member member : result) {
        System.out.println("member.name : " + member.getName());
      }
      
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    
    emf.close();
  }
}
