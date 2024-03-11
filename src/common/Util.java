package common;

import java.text.SimpleDateFormat;

import excpt.MemberNotFoundException;
import model.MemberVO;

public class Util {

  //전체가 static 메소드로 이루어져 있는 유틸클래스들은 객체를 인스턴스화할 필요가 없기 때문에
  //흔히 클래스를 만들때 인스턴스화를 막기 위해 생성자를 private 으로 만든다.  
  private Util(){};
  
  public static void help() {
    System.out.println("명령어 사용법:");
    System.out.println("회원등록 – new 아이디 이름 이메일 연락처 비번 비번확인");
    System.out.println("정보수정 – modify 아이디 이름 이메일 연락처 비번 변경비번");
    System.out.println("회원삭제 – del 아이디");
    System.out.println("회원목록 – list");
    System.out.println("회원정보 – info 아이디");
    System.out.println("회원찾기 – search 이름");
    System.out.println("버전확인 – ver");
    System.out.println("도움말 - help");
    System.out.println("종료 – exit");
    System.out.println();
  } 
  
  public static void ver() {
    System.out.println("이 프로그램의 버전은 1.0 입니다.");
    System.out.println();
  }
  
  public static void print(MemberVO vo) {
    
    if(vo==null) throw new MemberNotFoundException();    
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    System.out.println(
        "회원정보 : 아이디:"+vo.getId()
        +", 이메일:"+vo.getEmail()
        +", 이름:"+vo.getName()
        +", 암호:"+vo.getPwd()
        +", 폰번호:"+vo.getPhone()
        +", 등록일:"+sdf.format(vo.getRegDate())
    );
    
  }  
}



























