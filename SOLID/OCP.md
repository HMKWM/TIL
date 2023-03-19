# OCP

개방 폐쇄의 원칙(Open/Close Principle)이란?

객체 지향 설계원칙(SOLID)중 하나이며, 확장에는 열려있어야 하며, 수정에는 닫혀야 한다는 원칙이다.

    class Member{
      void play(Guitar guitar){...}
    }

위와같은 예제를 만들었다면, play메서드는 오직 기타만 연주할 수 있다.

만약 피아노를 추가하고싶다면, 오버로딩으로 피아노를 매개변수로 받는 메서드를 만들어야한다.

하지만 다음과 같이 작성하면 Member 클래스 수정없이 해결할 수 있다.

    class Member{
      void play(Instrument instrument){...}
    }
    
    interface Instrument{}
    class Guitar implement Instrument{}
    class Piano implement Instrument{}
    
이로서 OCP를 지킬 수 있다.
