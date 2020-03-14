import models.Cat;
import models.Dog;

public class AnimalsApp {

   public static void main(String[] args) {

      Cat cat = new Cat();
      Dog dog = new Dog();

      System.out.println("Кот:");
      cat.onRun(200);
      cat.onSwim(10);
      cat.onJump(2);

      System.out.printf("%nСобака:%n");
      dog.onRun(500);
      dog.onSwim(15);
      dog.onJump(0.4);

   }
}
