# DTO, VO, Entity 용어

## DTO

DTO란 계층간의 데이터 교환을 위한 객체이다.

데이터 교환만을 위해 사용되므로, getter/setter의 메소드만 갖는다.

    public class Member{
    
      private Long id;
      private String password;
      
      public Long getId(){
        return id;
      }
      public String getPassword(){
        return password;
      }
      
      public void setId(){
        this.id = id;
      }
      
      public void setPassword(){
        this.password = password;
      }
    }
    
## VO

VO(Value Object)란 값 그자체를 표현하는 객체이다.

로직을 포함할 수 있으며, 객체의 불변성을 보장한다.

불변성을 보장하기에 setter는 구현하지 않는다.

equals 와 hashCode()를 오버라이딩 한다.

## entity

Entity Class는 실제 DataBase의 테이블과 1 : 1로 Mapping 되는 클래스이다.

클라이언트와 요청을 주고받을때 사용하면 안된다.

로직을 포함할 수 있다.

JPA를 사용할때, entity객체는 dao, service단까지 사용하고 client와 controller단에서 사용하는 것 같다.
    
