package ctrl;

import common.Factory;
import common.Util;
import excpt.MemberNotFoundException;
import srv.SearchService;

public class SearchController implements Controller {

  @Override
  public void execute(String[] userInputs) {
    
    if(userInputs.length != 2) {
      System.out.println("입력한 내용이 형식에 맞지 않습니다. 다시 입력해주세요.");
      Util.help();
      return;
    }
    
    SearchService srchSrv = Factory.getInstance().getSrchSrv();

    try {
      srchSrv.srchList(userInputs[1]);    
    }catch(MemberNotFoundException e) {
      System.out.println("에러 : "+e.getMessage());
    }
  }

}
