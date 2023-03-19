# SRP 


단일책임원칙(Single responsibility principle)이란? 

SRP는 객체 지향 설계원칙(SOLID)중 하나이며, 한 클래스가 하나의 책임을 갖는것을 말한다.

이를 따르면 코드의 유지보수성과 재사용성이 향상되고, 변경에 대한 파급효과를 줄일 수 있다.

    class Member{
        String id;
        String pw;
        void setId(String id){...};
        void setPw(String id){...};
        void saveToDB(){//DB에 member정보를 저장한다.}
    } 
위의 예제는 두가지 책임을 가지고 있어 SRP를 위반한다.
첫번째 책임은 Member의 필드(속성)관리이고,
두번째 책임은 Member의 필드값을 DB에 저장하는 책임이다.
위와 같은 설계는 DB저장하는 코드에 변경해야할시, Member 클래스가 수정된다는 것이다.
위는 다른 문제를 야기할수있다. 그러므로 다음과 같이 수정해야한다.

    class Member{
        String id;
        String pw;
        void setId(String id){...};
        void setPw(String id){...};
    }
    
    class MemberDB{
        void saveToDB(Member member){...};
    }

위의 코드는 Member 클래스는 필드 관리의 책임만 가지고있고,
MemberDB 클래스는 DB에 저장하는 책임만 가지고있다. 이로서 SRP를 지킬 수 있다.
