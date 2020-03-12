package models;

public abstract class Animals {

   protected String name;
   protected int count;

   protected final int MAX_DISTANCE_RUN_DOG = 500;
   protected final int MAX_DISTANCE_SWIM_DOG = 10;
   protected final double MAX_HEIGHT_JUMP_DOG = 0.5;
   protected final int MAX_DISTANCE_RUN_CAT = 200;
   protected final double MAX_HEIGHT_JUMP_CAT = 10;

   public Animals(String name) {
      this.name = name;
   }

   public abstract void onRun(int lengthDistance);

   public abstract void onSwim(int lengthDistance);

   public abstract void onJump(double heightObstacle);

   public void getCount(){
      System.out.println(count);
   }
}
