package excpt;

public class MemberNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  @Override
  public String getMessage() {
    return "아이디에 해당하는 회원정보가 없습니다.";
  }
  
  

}
