package week07;

public class Dog extends Animal {

  String name;

  public Dog(String name) {
    this.name = name;
  }

  public void bark() {
    System.out.println("멍멍");
  }
}
