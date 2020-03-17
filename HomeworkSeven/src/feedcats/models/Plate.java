package feedcats.models;

import feedcats.notification.EventManager;

/**
 * Класс Plate описывает состояние и поведение миски для еды
 */

public class Plate {

   private int food;                      //Поле еда - значение задается в ручную

   public EventManager events;            //Объявление переменной базового издателя

   /**
    * Реализация порождающего паттерна Singleton
    */
   private static volatile Plate plate;   //Объявление переменной объекта класса Cat

   public static Plate getPlate(int food) {//Метод создает единственный объект plate класса Plate
      if (plate == null) {
         plate = new Plate(food);
      }
      return plate;
   }

   /**
    * Конструктор объекта plate. Устанавливает начальное значение поля объекта,
    * инициализирует переменную базового издателя
    *
    * @param food Целочисленное значение количества еды в миске
    */
   private Plate(int food) {
      this.food = food;
      events = new EventManager();
   }

   /**
    * Метод выводит информацию о состоянии миски: какое количество еды находится в миске
    */
   public void info() {
      System.out.printf("Количество еды в миске: %d%n", food);
   }

   /**
    * Метод уменьшает количество еды в миске, если аппетит кота не превышает значения количества еды в миске
    *
    * @param appetite Целочисленное значение аппетита кота
    * @return Возвращает целочисленное значение аппетита кота после еды
    */
   public int decreaseFood(int appetite) {
      if (food >= appetite) {  //Аппетит кота не превышает количество еды в миске
         food -= appetite;    //Уменьшается количество еды в миске
         return 0;            //Возвращается значение, что кот уталил свой голод
      }
      return appetite;        //Иначе возвращается значение аппетита, кот не поел
   }

   public int getFood() {
      return food;
   }

   /**
    * Метод добавляет некоторое количество еды в миску,
    * оповещает голодных котов о наполнении миски
    *
    * @param countFood Количество еды добавляемой в миску
    */
   public void addFood(int countFood) {
      food += countFood;                                          //Добавление дополнительной еды в миску
      System.out.printf("В миску добавлно %d еды%n", countFood);  //Вывод информации о добавлении еды в миску
      info();                                                     //Информация о состоянии миски
      events.notify(plate);                                       //Оповещение голодных котов о добавлении
      //дополнительной еды в миску
   }

}
