package excpt;

public class PasswordNotMatchingException extends RuntimeException{

  private static final long serialVersionUID = 1L;

  @Override
  public String getMessage() {
    return "저장된 비밀번호와 일치하지 않습니다.";
  }
  
}
