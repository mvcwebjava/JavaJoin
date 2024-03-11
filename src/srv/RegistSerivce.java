package srv;

import java.util.Date;

import excpt.DuplicateMemberIdException;
import model.MemberDTO;
import model.MemberVO;
import repo.MemberDAO;

public class RegistSerivce {

  MemberDAO dao;

  // Association has-a (느슨한 결합) - 필요한 의존객체를 외부에서 주입받는다. 
  public RegistSerivce(MemberDAO dao) {
    this.dao = dao;
  }

  public void regist(MemberDTO dto) {
    
     //기존에 등록된 정보와 중복여부
     if(dao.getOne(dto.getId())!=null) {
       throw new DuplicateMemberIdException();//예외오류 발생시 아래의 코드는 실행되지 않는다.
     }
     
     MemberVO vo = new MemberVO(
         dto.getId(),         
         dto.getName(),
         dto.getEmail(),
         dto.getPhone(),
         dto.getPwd(),
         new Date()
         );
     
     
     //DAO 메소드를 통해서 저장소에 저장
     dao.save(vo);//데이터 등록
     System.out.println("등록했습니다.");

  }
}
