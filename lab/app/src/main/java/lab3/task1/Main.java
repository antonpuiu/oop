package lab3.task1;

import utils.*;

class Form {
  private String color;

  Form() {
    this("white");
  }

  Form(String color) {
    this.color = new String(color);
  }

  float getArea()
  {
    return 0;
  }

  @Override
  public String toString() {
    return "This form has the color " + color;
  }
}

public class Main implements MainTask {
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
