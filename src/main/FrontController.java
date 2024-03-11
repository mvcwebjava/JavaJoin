package main;

import java.util.Scanner;

import common.Util;
import ctrl.Controller;
import ctrl.HandlerMapping;

public class FrontController {

  public static void main(String[] args) {

    Util.help();

    Scanner sc = new Scanner(System.in);
    
    while(true) {
      
      System.out.println("명령어를 입력하세요:");
      String userInput = sc.nextLine();
      
      //사용자가 입력한 명령어에서 데이터 분리
      String[] userInputs = userInput.split(" ");
      
      Controller ctrl = null;
      
      if(userInput.equalsIgnoreCase("exit")) {
        System.out.println("종료합니다.");
        break;//return 또는 System.exit(0)을 하면 sc.close()에서 에러 발생 
      }

      if(userInput.startsWith("new")) {
        ctrl = HandlerMapping.getInstance().getController("new");
        ctrl.execute(userInputs);    
        
      } else if (userInput.compareToIgnoreCase("list") == 0) {
        ctrl = HandlerMapping.getInstance().getController("list");
        ctrl.execute(userInputs);

      } else if(userInput.startsWith("info")) {
        ctrl = HandlerMapping.getInstance().getController("info");
        ctrl.execute(userInputs);
        
      } else if(userInput.startsWith("modify")) {
        ctrl = HandlerMapping.getInstance().getController("modify");
        ctrl.execute(userInputs);       
        continue;
        
      } else if(userInput.startsWith("del")) {
        ctrl = HandlerMapping.getInstance().getController("del");
        ctrl.execute(userInputs);
        
      } else if(userInput.startsWith("search")) {
        ctrl = HandlerMapping.getInstance().getController("search");
        ctrl.execute(userInputs);
        
      } else if(userInput.compareToIgnoreCase("help") == 0) {
        Util.help();
        
      }  else if(userInput.compareToIgnoreCase("ver") == 0) {
        Util.ver();
        
      } else {
        System.out.println("잘못된 명령어 입니다. 아래의 명령어 사용법을 확인하세요\n");// end of if
        Util.help();
      }
      
      //Util.help();
    }//end of while
    
    sc.close();
  }//end of main
}
