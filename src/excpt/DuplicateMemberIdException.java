package excpt;

public class DuplicateMemberIdException extends RuntimeException{

  private static final long serialVersionUID = 1L;

  @Override
  public String getMessage() {
    return "이미 등록된 아이디 입니다.";
  }
  
}
