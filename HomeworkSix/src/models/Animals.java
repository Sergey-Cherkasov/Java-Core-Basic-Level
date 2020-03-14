package models;

public class Animals {

   private int maxDistanceRun;
   private int maxDistanceSwim;
   private double maxHeightJump;

   public Animals(int maxDistanceRun, int maxDistanceSwim, double maxHeightJump) {
      this.maxDistanceRun = maxDistanceRun;
      this.maxDistanceSwim = maxDistanceSwim;
      this.maxHeightJump = maxHeightJump;
   }

   public void onRun(int lengthDistance){
      if (lengthDistance > maxDistanceRun){
         System.out.printf("не сможет пробежать %d м. Максимальная дистанция: %d м.%n", lengthDistance, maxDistanceRun);
      } else {
         System.out.printf("пробежал(а) %d м. Максимальная дистанция: %d м.%n", lengthDistance, maxDistanceRun);
      }
   }

   public void onSwim(int lengthDistance){
      if (lengthDistance > maxDistanceSwim){
         System.out.printf("не сможет проплыть %d м. Максимальная дистанция: %d м.%n", lengthDistance, maxDistanceSwim);
      } else {
         System.out.printf("проплыл(а) %d м. Максимальная дистанция: %d м.%n", lengthDistance, maxDistanceSwim);
      }
   }

   public void onJump(double heightObstacle){
      if (heightObstacle > maxHeightJump){
         System.out.printf("не сможет прыгнуть на высоту %.2f м. Максимальная высота для прыжка: %.2f м.%n",
                 heightObstacle, maxHeightJump);
      } else {
         System.out.printf("выпрыгнул(а) на высоту на высоту %.2f м. Максимальная высота для прыжка: %.2f м.%n",
                 heightObstacle, maxHeightJump);
      }
   }

}
