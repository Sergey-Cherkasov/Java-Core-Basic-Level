package models;

public class Dog extends Animals {

   public Dog(String name){
      this.name = name;
   }

   @Override
   public void onRun(int lengthObstacle) {
      if (lengthObstacle > MAX_DISTANCE_RUN_DOG){
         System.out.println(name + " не сможет пробежать " + lengthObstacle + " м.");
      } else {
         System.out.println(name + " пробежал " + lengthObstacle + " м.");
      }
   }

   @Override
   public void onSwim(int lengthObstacle) {
      if (lengthObstacle > MAX_DISTANCE_SWIM_DOG){
         System.out.println(name + " не сможет проплыть " + lengthObstacle + " м.");
      } else {
         System.out.println(name + " проплыл " + lengthObstacle + " м.");
      }
   }

   @Override
   public void onJump(double highObstacle) {
      if (highObstacle > MAX_HEIGHT_JUMP_DOG){
         System.out.println(name + " не сможет прыгнуть на высоту " + highObstacle + " м.");
      } else {
         System.out.println(name + " выпрыгнул на высоту " + highObstacle + " м.");
      }
   }
}
