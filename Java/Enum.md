# Enum

enum이란? 

enumeration의 앞글자로, 열거라는 뜻을 가지고있다.

자바에서는 JDK1.5부로 새로 추가되었고, 여러 상수를 정의할 때 사용하면 유용하다.

enum은 내부적으로 Enum을 상속받으므로, 다중상속이 불가능한 자바에서는 상속을 받을 수 없다. 인터페이스는 구현할 수 있다.

enum에 정의된 상수는 public static final이 생략되어있다. 그래서 인스턴스를 생성하지않고 선언할 수 있다.

    enum Day{MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}
    
    class Main{
        public static void main(String[] args){
            Day monday = Day.MONDAY;
        }
    }
    
enum은 상수에 멤버를 추가할 수 있다.

    enum Day{
        MONDAY(0), TUESDAY(1), WEDNESDAY(2), THURSDAY(3), FRIDAY(4), SATURDAY(5), SUNDAY(6);
        private final int value;
        Day(int value){this.value = value;}
        public int getValue(){return value;}
    } 
    
멤버를 추가할때에는 필드를 추가하고, 생성자를 추가해야한다.

enum 타입은 제한된 값만 받으므로, 다음과 같이 활용할 수 있다.

    class Member{
        private Long id;
        private String name;
        private Role role;
    }
    
    enum Role{
        ADMIN, STUDENT, TEACHER
    }

만약 데이터베이스 Member 테이블에 role 컬럼에 제한된 값만 넣고싶다면 위와같이 작성할 수 있다.
이러한 enum의 사용은 의도치 않은 값이 들어가는 것을 방지할 수 있다.

