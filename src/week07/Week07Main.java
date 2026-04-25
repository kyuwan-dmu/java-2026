package week07;

public class Week07Main {
  public static void main(String[] args) {

    Animal dog = new Dog("Dog");
    Animal pig = new Pig("Pig");
    Animal cow = new Cow("Cow");
    Animal penguin = new Penguin("Penguin");

    Animal[] animals = {dog, pig, cow, penguin};
    for (Animal animal : animals) {
      animal.bark();
      animal.sleep();
    }

//    dog.bark();
//    pig.bark();
//    cow.bark();
//    penguin.bark();
  }
}
