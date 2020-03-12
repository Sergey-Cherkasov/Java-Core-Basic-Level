package models;

public class Cat extends Animals {

   public Cat(String name) {
      super();
      this.name = name;
   }

   @Override
   public void onRun(int lengthObstacle) {
      if (lengthObstacle > MAX_DISTANCE_RUN_CAT) {
         System.out.println(name + " не сможет пробежать " + lengthObstacle + " м.");
      } else {
         System.out.println(name + " пробежал " + lengthObstacle + " м.");
      }
   }

   @Override
   public void onSwim(int lengthObstacle) {
      System.out.println("Кот не умеет плавать!");
   }

   @Override
   public void onJump(double highObstacle) {
      if (highObstacle > MAX_HEIGHT_JUMP_CAT) {
         System.out.println(name + " не сможет прыгнуть на высоту " + highObstacle + " м.");
      } else {
         System.out.println(name + " выпрыгнул на высоту " + highObstacle + " м.");
      }
   }
}
