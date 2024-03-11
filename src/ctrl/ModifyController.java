package ctrl;

import common.Factory;
import common.Util;
import excpt.MemberNotFoundException;
import excpt.PasswordNotMatchingException;
import model.MemberDTO;
import srv.ModifyService;

public class ModifyController implements Controller {

  @Override
  public void execute(String[] userInputs) {

    //정보수정 – modify 아이디 이름 이메일 연락처 비번
    
    if(userInputs.length != 7) {
      System.out.println("입력한 내용이 형식에 맞지 않습니다. 다시 입력해주세요.");
      Util.help();
      return;
    }
    MemberDTO dto = new MemberDTO();
    dto.setId(userInputs[1]);
    dto.setName(userInputs[2]);
    dto.setEmail(userInputs[3]);
    dto.setPhone(userInputs[4]);
    dto.setPwd(userInputs[5]);
    dto.setConfirmPwd(userInputs[6]);
    
    ModifyService modifySrv = Factory.getInstance().getModifySrv();

    try {
      modifySrv.change(dto);
    }catch(MemberNotFoundException | PasswordNotMatchingException e) {
      System.out.println("에러 : "+e.getMessage());      
    }
    
  }

}
