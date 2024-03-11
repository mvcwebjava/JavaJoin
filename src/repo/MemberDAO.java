package repo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.MemberVO;

public class MemberDAO {

  private Map<String, MemberVO> mapDB
  = new HashMap<String, MemberVO>();

  
  //Map 저장소에 등록
  public void save(MemberVO vo) {   
    mapDB.put(vo.getId(), vo);
  }
  

  //해당 id로 등록된 정보 유무
  public MemberVO getOne(String id) {
    return mapDB.get(id);
  }
  
  
  public boolean existsById(String id) {
    return mapDB.containsKey(id);
  }
  
  
  //회원목록
  public Collection<MemberVO> findAll() {   
    return mapDB.values();    
  }

  
  //정보변경
  public void update(MemberVO vo) {
    mapDB.put(vo.getId(), vo);    
  }
  
  
  //삭제
  public void deleteById(String id) {
    mapDB.remove(id);
  }

}
