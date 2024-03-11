package srv;

import excpt.MemberNotFoundException;
import excpt.PasswordNotMatchingException;
import model.MemberDTO;
import model.MemberVO;
import repo.MemberDAO;

public class ModifyService {

  private MemberDAO dao;
  
  // Association has-a (느슨한 결합) - 필요한 의존객체를 외부에서 주입받는다. 
  public ModifyService(MemberDAO dao) {
    this.dao = dao;
  }
  
  public void change(MemberDTO dto) {    
    
    //기존에 등록된 정보와 중복여부
    MemberVO vo = dao.getOne(dto.getId());
    if(vo==null) {
      throw new MemberNotFoundException();
    } else if(!vo.getPwd().equals(dto.getPwd())) {
      throw new PasswordNotMatchingException();
    }
    
    vo.setId(dto.getId());
    vo.setName(dto.getName());
    vo.setEmail(dto.getEmail());
    vo.setPhone(dto.getPhone());
    vo.setPwd(dto.getConfirmPwd());  
    
    //DAO 메소드를 통해서 저장소에 등록
    dao.update(vo);
    System.out.println("수정했습니다.");
  }
}
