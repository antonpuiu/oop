package lab3.task1;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
  @Override
  public void main() {
    Form form1 = new Form();
    Form form2 = new Form("blue");

    System.out.println(form1);
    System.out.println(form2);
  }

  @Override
  public int getId() {
    return 1;
  }
}
