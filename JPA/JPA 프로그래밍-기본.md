# JPA 소개

## SQL 중심적인 개발의 문제점

### 지루한 코드의 무한반복

#### CRUD의 반복, 자바객체를 SQL로, SQL를 자바객체로.

    class Member{
        private Long id;
        private String name;
        ...
    }
    
    insert into Member(id, name) values (?, ?)
    select id, name from Member
    update member set ...
    ...
    
또, age 컬럼을 추가한다면 각 insert문, select문, update문에 age를 추가로 작성해야한다.

ㅤ

#### 객체 지향과 관계형 데이터베이스의 패러다임 불일치

주문 클래스를 만들고, 주문 정보안에 고객정보가 들어가야한다면,

    class Order{
        private Long id;
        private Member member;
        ...
    }

위와 같이 작성하는게 객체지향적이다. 

만약 객체지향적인 설계를 위해 이대로 사용하고 싶다면, join 문을 사용하거나 혹은 더 많은 코드를 작성해야한다.

Member 객체에도 만약 필드값으로 객체가 있다면, 더욱 많은 것을 고려해야한다.


    class Item{
        private Long id;
        private int price;
        ...
    }
    
    class Album extends Item{
        private String artist;
        ...
    }
    
    class Book extends Item{
        private String author;
        ...
    }

상속관계의 경우도 문제가 된다. 위의 상속관계를 DB에 적용시킨다면, 많은 작업이 필요할 수도 있다.

    String memberId = "100";
    Member member1 = memberDAO.getMember(memberId);
    Member member2 = memberDAO.getMember(memberId);
    member1 == member2; //다르다.

또, 자바 컬렉션에 저장할때와는 달리, 다른 참조값을 반환한다.

## JPA

### JPA란?

- Java Persistence API
- 자바 진영의 ORM 기술 표준

#### ORM 이란?

- Object-relational mapping(객체 관계 매핑)
- 객체는 객체대로 설계
- 관계형 데이터베이스는 관계형 데이터베이스대로 설계
- ORM 프레임워크가 중간에서 작성
- 대중적인 언어에는 대부분 ORM 기술이 존재

JPA는 Entity를 분석하여, SQL를 생성해주어, 애플리케이션과 JDBC 사이에서 패러다임 불일치를 해결해준다.

JPA를 사용함으로서 얻을 수 있는 장점은 다음과 같다.

- SQL 중심적인 개발에서 객체 중심으로 개발
- 생산성과 유지보수
- 패러다임 불일치 해결
- 성능
- 데이터 접근 추상화와 벤더 독립성
- 표준

#### 정리
패러다임 불일치로 RDB에 맞춰 코드를 작성해야 한다. 혹은 더 많은 작업을 해야한다.
이를 JPA가 해결해주어, 각 패러다임에 맞게 설계할 수 있다.


    
