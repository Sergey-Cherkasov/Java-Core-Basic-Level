package models;

public class Cat extends Animals {

   public Cat(String name){
      super();
      this.name = name;
   }

   @Override
   public void run(int lengthObstacle) {
      if (lengthObstacle > 500){
         System.out.println(name + " не сможет пробежать " + lengthObstacle + " м.");
      } else {
         System.out.println(name + " пробежал " + lengthObstacle + " м.");
      }
   }

   @Override
   public void swim(int lengthObstacle) {
      System.out.println("Кот не умеет плавать!");
   }

}
