package models;

public abstract class Animals {

   protected String name;
   protected int count;

   public abstract void run(int lengthObstacle);

   public abstract void swim(int lengthObstacle);

   public void getCount(){
      System.out.println(count);
   }
}
