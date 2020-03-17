package feedcats;

import feedcats.models.Cat;
import feedcats.models.Plate;

import java.util.ArrayList;
import java.util.List;

public class FeedCats {

   public static void main(String[] args) {

      final int MAX_NUMBER_CATS = 10;      //Константа максимального количества котов

      List<Cat> cats = new ArrayList<>(); //Список объектов класса Cat
      Plate plate = Plate.getPlate(100);  //Создание и инициализация объекта plate (миска)

      /*
         Объявление и инициализация переменной
         для подсчета общего аппетита всех котов
      */
      int sumAppetitesCats = 0;

      /*
         Создание списка объектов класса Cat, передача конструктору объекта cat значение поля name,
         подсчитывается общий аппетит котов, объект cat подписывается на состояние миски
       */
      for (int iteratorCat = 0; iteratorCat < MAX_NUMBER_CATS; iteratorCat++) {
         cats.add(new Cat("Cat " + (iteratorCat + 1)));
         sumAppetitesCats += cats.get(iteratorCat).getAppetite();
         //Подписка кота на изменения в миске
         plate.events.subscribe(cats.get(iteratorCat));
         System.out.printf("Аппетит %s - %d%n", cats.get(iteratorCat).getName(), cats.get(iteratorCat).getAppetite());
      }

      System.out.printf("%nОбщий аппетит всех котов: %d%n" + "Количество еды в миске: %d%n%n", sumAppetitesCats, plate.getFood());

      for (Cat cat : cats) {              //Кормление котов
         if (cat.eat(plate)) {             //Кот наелся
            plate.events.unsubscribe(cat);//Кот отписался от состояния миски
         }
      }

      printSatietyCats(cats);         //Вывод состояния котов
      System.out.println();
      plate.info();                   //Вывод состояния миски
      plate.addFood(10);   //Добавление еды в миску
      System.out.println();
      printSatietyCats(cats);         //Вывод состояния котов после добавления еды в миску

   }

   /**
    * Метод выводит состояние котов: не голоден/голоден (true/false)
    *
    * @param cats Список объектов класса Cat
    */
   private static void printSatietyCats(List<Cat> cats) {
      for (Cat cat : cats) {
         System.out.println(cat);
      }
   }

}
