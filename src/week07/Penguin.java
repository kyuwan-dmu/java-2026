package week07;

public class Penguin extends Animal {

  String name;

  public Penguin(String name) {
    this.name = name;
  }

  public void bark() {
    System.out.println("Penguin");
  }
}
