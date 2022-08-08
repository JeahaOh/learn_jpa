# JPA 학습하기

인프런 자바 ORM 표준 JPA 프로그래밍 - 기본편

## JPA

- Java Persistence API
- 자바 진영의 ORM 표준

## ORM

- Object-relational Mapping (객체 관계 매핑)
- 객체는 객체대로, 관겨형 DB는 관계형 DB대로 설계
- ORM 프렝임워크가 중간에서 매핑
- 객체를 ORM 프레임워크에 저장하면, ORM 프레임워크가 SQL을 생성하여 객체를 DB에 관리
- 대중적인 언어에는 대부분 ORM 기술이 존재

## JPA를 사용하는 이유

- SQL 중심의 개발에서 객체 중신의 개발
- 개발 생산성 향상
- 유지보수 편의
- OOP와 RDBMS간 패러다임의 불일치 해결
- 성능 향상
- 데이터 접근 추상화와 벤더 독립성
- 자바 ORM 표준 기술

## H2 database

H2 DB 강의는 2.1.199 버젼이며, 학습은 **2.1.212** 버전으로 진행함.  
설치법은 간단하기 때문에 따로 기록하지 않음.  

- 자바기반 오픈소스 RDBMS
- 서버 모드와 임베디드 모드의 인메모리 DB 지원
- 브라우져 기반의 콘솔모드 사용 가능
- 별도 설치 필요 없음
- 저용량
- 표준 SQL 지원
- 로컬 및 테스트환경에 적합

### 실행 방법

1. shell 실행 
  - ```shell
      cd 설치 위치/bin
      chmod 700 h2.sh
      ./h2.sh
    ```
2. 브라우져 실행
3. localhost:8082 접속
4. Generic H2 (Server)
5. JDBC URL
  - 처음 접속시 : `jdbc:h2:~/test`
  - 그 후 : `jdbc:h2:tcp://localhost/~/test`

### 


--- 
