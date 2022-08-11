package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class PersistenceMain {
  public static void main(String[] args) {
    // 하나만 생성해서 어플리케이션 전체에서 공유
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    // 쓰레드간 공유 X (사용하고 버려야 함)
    EntityManager em = emf.createEntityManager();
    
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    
    try {
      /*
      // 비영속
      Member member = new Member();
      long id = System.currentTimeMillis();
      System.out.println("long id : " + id);
      member.setId(id);
      member.setName("Hell JPA");
      
      // 영속 상태 -> 1차 캐시에 저장됨
      System.out.println("== BEFORE PERSIST ==");
      em.persist(member);
      System.out.println("== AFTER PERSIST ==");
      
      // 1차 캐시에서 조회
      Member findMember = em.find(Member.class, id);
      System.out.println("findMember.id : " + findMember.getId());
      System.out.println("findMember.name : " + findMember.getName());
      
      // 회원 엔티티를 영속성 컨텍스트에서 분리, 준영속 상태
      //em.detach(member);
      
      // 객체를 삭제한 상태
      //em.remove(member);
      
      // 쿼리 실행 시점
      tx.commit();
      */
      
      /*
      // 1차 캐시로 반복 가능한 읽기 (Repeatable read) 등급의 트랜잭션 격리 수준을 DB가 아닌 application 차원에서 제공
      Member findMember1 = em.find(Member.class, 100L);
      Member findMember2 = em.find(Member.class, 100L);
      
      System.out.println("is same ? " + (findMember1 == findMember2));
      */
      
      /*
      // batch query 지원
      Member member1 = new Member(System.currentTimeMillis(), "A");
      Member member2 = new Member(System.currentTimeMillis(), "B  ");
      em.persist(member1);
      em.persist(member2);
      System.out.println("------------------");
      */
  
      // 변경 감지 -> 영속성 컨텍스트의 1차 캐시에 스냅샷을 저장, commit 되는 시점에서 비교해서 update 함
      /*
      Member member = em.find(Member.class, 100L);
      member.setName("adsf");
      System.out.println("------------------");
      */
      
      /**
       * 영속성 컨텍스트 플러시 하는 방법
       * em.flush()
       * tx.commit;
       * jpql 실행
       */
      /*
      Member member = new Member(200L, "flush");
      em.persist(member);
      em.flush();
      System.out.println("------------------");
       */
  
      /**
       * 플러시 모드 옵션
       *
       * FlushModeType.AUTO : 커밋이나 쿼리 실행시 플러시 (기본값)
       * FlushModeType.COMMIT : commit할 때만 플러시
       * 가급적 그냥 쓸 것
       */
  
      /**
       * 준영속상태로 만들기
       * detach(entity) : 특정 엔티티만 준영속 상태로 전환
       * clear() : 영속성 컨텍스트 완전 초기화
       * close() : 영속성 컨텍스트 종료
       */
      /*
      Member member = em.find(Member.class, 100L);
      member.setName("adsf");
      // 준영속
      em.detach(member);
      Member member2 = em.find(Member.class, 100L);
      System.out.println("------------------");
      */
  
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    } finally {
      em.close();
    }
    
    emf.close();
  }
}
