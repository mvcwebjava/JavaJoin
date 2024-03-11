package srv;

import excpt.MemberNotFoundException;
import model.MemberVO;
import repo.MemberDAO;

public class DeleteService {
  MemberDAO dao;

  // Association has-a (느슨한 결합) - 필요한 의존객체를 외부에서 주입받는다. 
  // 소스코드를 수정했을 때 연관있는 다른 파일의 수정을 최소화하는 코드작성 패턴
  // 변경사항이 발생해도 연관클래스가 코드를 수정하지 않도록 작성하는 것이 좋은 코딩이다. 
  public DeleteService(MemberDAO dao) {
    this.dao = dao;
  }
  
  public void delMember(String id) {
    MemberVO vo = dao.getOne(id);
    
    if(vo==null) {
      throw new MemberNotFoundException();
    }
    
    dao.deleteById(id);
    System.out.println("삭제했습니다.");
  }

}
