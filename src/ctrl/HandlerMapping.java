package ctrl;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
  
  private static HandlerMapping instance;
  public static HandlerMapping getInstance() {
    if (instance == null) {
      instance = new HandlerMapping();
    }
    return instance;
  }

  /*
      1. 팩토리 패턴이란?      
         팩토리 패턴은 객체를 생성하는 인터페이스를 미리 정의하지만, 
         인스턴스를 만들 클래스의 결정은 서브 클래스 쪽에서 결정하는 패턴이다. 
         여러개의 서브 클래스를 가진 슈퍼 클래스가 있을때, 
         들어오는 인자에 따라서 하나의 자식클래스의 인스턴스를 반환해주는 방식이다.  
      
      2. 팩토리 패턴의 장점
         팩토리 패턴은 클라이언트 코드로부터 서브 클래스의 인스턴스화를 제거하여 서로 간의 종속성을 낮추고, 
         합도를 느슨하게 하며(Loosely Coupled), 확장을 쉽게 한다.
      
      3. 팩토리 패턴은 클라이언트와 구현 객체들 사이에 추상화를 제공한다.
      
      4. 팩토리 패턴의 단점
         새로 생성할 객체가 늘어날 때마다, Factory 클래스에 추가해야 되기 때문에 클래스가 많아짐.       
   */
  
  //명령어과 command 객체를 서로 연결시켜 주는 역할
  Map<String, Controller> ctrlMap = new HashMap<String, Controller>();//생성자에서 초기화 시켜도 된다.

  private HandlerMapping() {
    ctrlMap.put("new",new RegistController());
    ctrlMap.put("modify",new ModifyController());
    ctrlMap.put("del",new DelController());
    ctrlMap.put("list",new ListController());
    ctrlMap.put("info",new InfoController());
    ctrlMap.put("search",new SearchController());
  }

  public Controller getController(String ctrl) {
    return ctrlMap.get(ctrl);
  }
}
