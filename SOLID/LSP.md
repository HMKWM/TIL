# LSP

리스코프 치환 원칙(Liskov substitution principle)이란?

객체 지향 설계원칙(SOLID)중 하나이며, 

프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀수 있어야 한다는 원칙이다.

단순히 컴파일 성공을 넘어서, 인터페이스를 구현한 구현체를 믿고 사용할수 있어야 하려면 이 원칙이 필요하다.

    class MyList implements List{
        List list = new ArrayList();
        void add(Object obj){
            list.remove(obj);
        }
    }
    
위의 예제는 List 인터페이스의 규약을 준수하지 않아 LSP 원칙를 위반하는 코드다.

사용자는 MyList의 add를 사용할때, 리스트에 요소를 추가하는 것을 기대하고 사용하지만, 다른 결과가 나타나게된다.

따라서 LSP 원칙을 지키려면, 부모 클래스(인터페이스)에 맞는 역할을 수행하도록 상속(구현)해야한다.

    class Rectangle {
      protected int width;
      protected int height;
   
      public void setWidth(int width) {
          this.width = width;
      }
 
      public void setHeight(int height) {
          this.height = height;
      }
   
      public int getWidth() {
          return width;
      }
      public int getHeight() {
          return height;
      }

      public int getArea() {
          return width * height;
      }
    }
 
    class Square extends Rectangle {
        @Override
        public void setWidth(int width) {
            super.setWidth(width);
            super.setHeight(width);
        }

        @Override
        public void setHeight(int height) {
            super.setHeight(height);
            super.setWidth(height);
        }
    }

위의 예시도 LSP를 위반한 코드이다.

만약 다음과 같이 작성한다고 하자

    Rectangle r = new Square();
    r.setWidth(5); r.setHeight(4);

위의 코드는 부모 클래스 Rectangle에서 요구하는 기능을 수행하지 못한다.

r 인스턴스의 getWidth, getHeight 메서드를 호출하면 두 값 모두 4가 나온다. 
