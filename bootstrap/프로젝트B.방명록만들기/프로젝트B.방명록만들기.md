# 프로젝트B.방명록만들기

https://www.boostcourse.org/web326/project/206/content/165#summary

GuestbookDao

싱글톤 방식으로 작성. 싱글톤 방식 장단점, 주의점

### GuestbookListServlet

RequestDispatcher란?

forward 와 include 의 기능을 가진 인터페이스.

forward 메서드는 페이지를 이동시키는 메서드. 서버 내부에서 처리됨.

include 메서드는 제어를 넘긴 대상 페이지의 처리가 완료된 후 결과와 함께, 원래페이지로 제어가 돌아오고 이후 나머지 처리.

### GuestbookWriteServlet

response 객체의 sendRedirect 메서드는, forward와 달리 클라이언트에게 redirect요청을 하여 클라이언트가 재요청을 하게 한다.

