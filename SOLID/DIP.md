# DIP
 
 의존 관계 역전(Dependency inversion principle)이란?
 
 객체 지향 설계원칙(SOLID)중 하나이며, 
 
 상위 모듈은 하위 모듈에 의존하는 것이 아닌, 추상화에 의존해야한다는 원칙이다.
 
 역할에 의존하여, 보다 느슨한 결합과 유연한 코드가 가능해진다.
 
 
    class MyBatisMemberRepository implements MemberRepository{
        ...
    }
    
    class MemberService{
        private final MemberRepository repository;
    
        public MemberService(MemberRepository repository){
            this.repository = repository;
        }
        ...
    }
    
 만약 위와 같이 작성한다면, MyBatisMemberRepository가 아닌 다른 Repository를 쓰고싶을때,
 
 Repository를 구현한 다른 클래스를 넣어도 사용이 가능하다.
 
 이 원칙을 준수하면 자연스럽게 OCP 원칙도 준수하게 된다.
