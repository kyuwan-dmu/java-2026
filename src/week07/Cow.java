package week07;

public class Cow extends Animal {

  String name;

  public Cow(String name) {
    this.name = name;
  }

  @Override
  public void bark() {
    System.out.println("음머");
  }

  @Override
  public void eat() {
    super.eat();
  }

  @Override
  public void sleep() {
    super.sleep();
  }
//  public void bark() {
//    System.out.println("음머");
//  }
}
