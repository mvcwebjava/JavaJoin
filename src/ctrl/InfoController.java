package ctrl;

import common.Factory;
import common.Util;
import excpt.MemberNotFoundException;
import srv.InfoService;

public class InfoController implements Controller{

  @Override
  public void execute(String[] userInputs) {
    
    // 유효성검사 - 전달받은 정보의 개수를 확인
    if(userInputs.length != 2) {
      System.out.println("입력한 내용이 형식에 맞지 않습니다. 다시 입력해주세요.");
      Util.help();
      return;
    }

    // infoSrv 주입처리
    InfoService infoSrv = Factory.getInstance().getInfoSrv();
    
    try {
      infoSrv.getMember(userInputs[1]);      
    }catch(MemberNotFoundException e) {
      System.out.println("에러 : "+e.getMessage());
    }
    
  }

}
