package ctrl;

import common.Factory;
import srv.ListService;

public class ListController implements Controller {

  @Override
  public void execute(String[] userInputs) {
    ListService lstSrv = Factory.getInstance().getLstSrv();
    lstSrv.getList();
  }

}
