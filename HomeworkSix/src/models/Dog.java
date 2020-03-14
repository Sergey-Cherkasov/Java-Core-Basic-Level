package models;

import java.math.BigDecimal;

import static java.lang.Math.random;

public class Dog extends Animals {

   public Dog() {
      super( (int) (random() * 501) + 100,
              (int) (random() * 21) + 5,
              BigDecimal.valueOf((random() * 1.4) + 0.1).doubleValue());
   }

}
