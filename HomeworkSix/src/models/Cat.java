package models;

import java.math.BigDecimal;

import static java.lang.Math.random;

public class Cat extends Animals {

   public Cat(){
      super( (int) (random() * 201) + 100,
              (int) (random() * 1),
              BigDecimal.valueOf((random() * 2) + 0.5).doubleValue());
   }

   public void onSwim(int lengthDistance) {
      System.out.println("не умеет плавать!");
   }

}
