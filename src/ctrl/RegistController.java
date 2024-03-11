package ctrl;

import common.Factory;
import common.Util;
import excpt.DuplicateMemberIdException;
import model.MemberDTO;
import srv.RegistSerivce;

public class RegistController implements Controller{

  //어노테이션 없이 메소드명에 오타를 낼 경우 컴파일러는 오버라이딩 한 것이 아니고 새로운 메소드로 인식한다.
  //어노테이션을 사용하면 에러표식이 나타나기 때문에 개발자의 오타를 예방할 수 있다.
  @Override
  public void execute(String[] userInputs) {
    
    if(userInputs.length != 7) {
      System.out.println("입력한 내용이 형식에 맞지 않습니다. 다시 입력해주세요.");
      Util.help();
      return;
    }
    
  //new 아이디 이름 이메일 연락처 비번 비번확인
    MemberDTO dto = new MemberDTO();
    dto.setId(userInputs[1]);
    dto.setName(userInputs[2]);
    dto.setEmail(userInputs[3]);
    dto.setPhone(userInputs[4]);
    dto.setPwd(userInputs[5]);
    dto.setConfirmPwd(userInputs[6]);
    
    if(!dto.comparePwd()) {
      System.out.println("입력한 비번이 일치하지 않습니다.");
      return;
    }
    
    RegistSerivce regSrv = Factory.getInstance().getRegSrv();
    
    try {
      regSrv.regist(dto);
      //System.out.println("등록했습니다.");
    }catch(DuplicateMemberIdException e) {
      System.out.println("에러 : " + e.getMessage());
    }
  }//end of execute
  
}
