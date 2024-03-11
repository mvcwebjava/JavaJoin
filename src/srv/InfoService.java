package srv;

import common.Util;
import excpt.MemberNotFoundException;
import model.MemberVO;
import repo.MemberDAO;

public class InfoService {
  //생성자함수를 통해 MemberDAO 객체를 주입받는 코드를 작성하시오.
  MemberDAO dao;

  // Association has-a (느슨한 결합) - 필요한 의존객체를 외부에서 주입받는다. 
  public InfoService(MemberDAO dao) {
    this.dao = dao;
  }
  
  //아이디를 전달받아 MemberDAO에서 조회후 전달받은 MemberVO객체를 출력하는 getMember 메소드를 작성하시오.
  public void getMember(String id) {
    
    MemberVO vo = dao.getOne(id);
    
    if(vo==null) {
      throw new MemberNotFoundException();
    }
    
    Util.print(vo);
  }

}
