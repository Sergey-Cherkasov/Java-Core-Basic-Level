import models.Animals;
import models.Cat;
import models.Dog;

public class AnimalsApp {

   public static void main(String[] args) {

      int countDog = 0;
      int countCat = 0;

      Animals[] animals = new Animals[5];

      animals[0] = new Cat("Мурзик");
      animals[1] = new Dog("Cesar");
      animals[2] = new Dog("Baron");
      animals[3] = new Cat("Барсик");
      animals[4] = new Dog("Ludvig");

      for (Animals animal: animals) {
         if (animal instanceof Dog) countDog++;
         if (animal instanceof Cat) countCat++;
      }
      System.out.println("Количество собак: " + countDog + ".\nКоличество котов: "+ countCat +".\n");

      animals[0].onRun(200);
      animals[3].onSwim(200);
      animals[1].onRun(501);
      animals[2].onSwim(10);
      animals[4].onJump(10);

   }
}
