package srv;

import java.util.Collection;

import common.Util;
import excpt.MemberNotFoundException;
import model.MemberVO;
import repo.MemberDAO;

public class SearchService {
  MemberDAO dao;

  // Association has-a (느슨한 결합) - 필요한 의존객체를 외부에서 주입받는다. 
  public SearchService(MemberDAO dao) {
    this.dao = dao;
  }
  
  // 검색된 회원정보 목록 출력
  public void srchList(String name) {

    Collection<MemberVO> list = dao.findAll();
    
    if(list.stream().count()==0) {
      throw new MemberNotFoundException();
    }
    
    list.stream().filter(vo->vo.getName().equals(name))
        .forEach(vo -> Util.print(vo)); 
  }

}
