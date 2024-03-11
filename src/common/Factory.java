package common;

import repo.MemberDAO;
import srv.DeleteService;
import srv.InfoService;
import srv.ListService;
import srv.ModifyService;
import srv.RegistSerivce;
import srv.SearchService;

//객체를 생성하고 필요로 하는 클래스에 의존객체를 주입해주는 DI담당 클래스 
public class Factory {
  
  private static Factory instance;
  public static Factory getInstance() {
    if (instance == null) {
      instance = new Factory();
    }
    return instance;
  } 
  

  // Compose has-a (강한결합) - 필요한 의존객체를 직접 생성한다. (유지보수 관점에서 문제점 유발)
  // 강한결합 : 의존 객체를 직접 생성하면 생성부터 메모리관리를 위한 소멸까지 해당객체의 라이프싸이클을 개발자가 다 관리해야 한다.
  private MemberDAO dao = new MemberDAO();
  
  public MemberDAO getDao() {
    return dao;
  }
  
  //미리 만들어져 있는 dao 객체를 생성자를 통해 주입시켜 dao 기능을 사용할 수 있게 만드는 것이 의존주입(DI) 이다.
  //이미 누군가가 생성한 객체를 주입받을 경우, 사용하기만 하면 되므로 약한 결합이 된다.
  //약한결합 : 개발자가 관리할 것이 적어진다는 장점이 있다.
  
  //회원목록
  private RegistSerivce regSrv = new RegistSerivce(dao);  
  public RegistSerivce getRegSrv() {
    return regSrv;
  }
  
  //전체리스트
  private ListService lstSrv = new ListService(dao);
  public ListService getLstSrv() {
    return lstSrv;
  }  
  
  //단일회원정보
  private InfoService infoSrv = new InfoService(dao);
  public InfoService getInfoSrv() {
    return infoSrv;
  }
  
  //회원정보수정
  private ModifyService modifySrv = new ModifyService(dao);
  public ModifyService getModifySrv() {
    return modifySrv;
  }
  
  private DeleteService delSrv = new DeleteService(dao);
  public DeleteService getDelSrv() {
    return delSrv;
  }
  
  private SearchService srchSrv = new SearchService(dao);
  public SearchService getSrchSrv() {
    return srchSrv;
  }
  
  
  
  
}