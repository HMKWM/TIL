# ISP

인터페이스 분리 원칙(interface segregation principle)이란?

객체 지향 설계원칙(SOLID)중 하나이며, 클라이언트가 자신이 이용하지 않는 메서드에 의존하면 안된다는 원칙이다.

    public interface Vehicle {
      void start();
      void stop();
      void openDoor();
    }
    
위의 예시는 탈것에 따라 메서드 openDoor()를 쓰지 않을 수도 있다.

따라서 이 경우에 ISP를 적용하여 인터페이스를 분리할 수 있다.

    public interface Vehicle{
        void start();
        void stop();
    }
    
    public interface Car extends Vehicle{
        void openDoor();
    }
    
    public class Bike implements Vehicle{
        void start(){...}
        void stop(){...}
    }
이렇게 분리된 인터페이스는 클라이언트가 필요한 메서드만 이용할 수 있게 만들어준다.
