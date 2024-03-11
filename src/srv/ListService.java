package srv;

import java.util.Collection;

import common.Util;
import model.MemberVO;
import repo.MemberDAO;

public class ListService {

  MemberDAO dao;

  // Association has-a (느슨한 결합) - 필요한 의존객체를 외부에서 주입받는다.
  // 생성자함수를 통한 의존객체 주입
  public ListService(MemberDAO dao) {
    this.dao = dao;
  }
  
  // 전체회원정보 목록 출력 함수
  public void getList() {

    Collection<MemberVO> list = dao.findAll();

    list.stream()
        .forEach(vo -> Util.print(vo));
 
  }
}
