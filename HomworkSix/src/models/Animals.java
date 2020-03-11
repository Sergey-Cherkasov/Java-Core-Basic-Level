package models;

public abstract class Animals {

   protected String name;
   protected int count;

   public abstract void onRun(int lengthObstacle);

   public abstract void onSwim(int lengthObstacle);

   public abstract void onJump(double highObstacle);

   public void getCount(){
      System.out.println(count);
   }
}
