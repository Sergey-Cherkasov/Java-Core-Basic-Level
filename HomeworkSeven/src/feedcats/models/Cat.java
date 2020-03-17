package feedcats.models;

import feedcats.notification.EventPlateListener;

/**
 * Класс Cat описывает состояние и поведение кота, реализует интерфейс слушателя EventPlateListener
 */

public class Cat implements EventPlateListener {

   //Объявление полей объекта Cat
   private String name;       //Имя кота - формируется автоматически
   private int appetite;      // Аппетит кота - целочисленное значение формируется автоматически методом Math.random
   private boolean satiety;   // Сытость кота - булевое значение

   //Объявление констант. Применяются для формирования значения аппетита кота
   final int MIN_NUMBER_APPETITE = 5;  //Минимальный порог аппетита кота
   final int MAX_NUMBER_APPETITE = 15; //Максимальный порог аппетита кота

   /**
    * Конструктор объекта Cat. Получает значение имени кота. Заполняет поля объекта начальными значениями.
    *
    * @param name Имя кота.
    *             Пример заполнения полей:
    *             name - Cat 1
    *             appetite -  13
    *             satiety - false
    */
   public Cat(String name) {
      this.name = name;
      this.appetite = (int) (Math.random() * (MAX_NUMBER_APPETITE - MIN_NUMBER_APPETITE + 1)) + MIN_NUMBER_APPETITE;
      this.satiety = false;
   }

   /**
    * Метод кормления кота изменяет значение поле satiety объекта Cat на true/false.
    *
    * @param plate Объект Plate - Миска с едой/без еды
    * @return Возвращает true - если коту хватило еды и он наелся, false - коту не хватило еды и он остался голодным :)
    */
   public boolean eat(Plate plate) {
      appetite = plate.decreaseFood(appetite);  //Поле appetite изменяет свое значение во время кормления кота
      if (appetite == 0) {                      //Если кот наелся
         return satiety = true;                 //Поле satiety объекта Cat принимает значение true
      }
      return false;
   }

   /**
    * Переопределенный метод toString.
    *
    * @return Возвращает строку с именем кота и его состоянием
    */
   @Override
   public String toString() {
      return getName() + " наелся - " + isSatiety();
   }

   public String getName() {
      return name;
   }

   public int getAppetite() {
      return appetite;
   }

   public boolean isSatiety() {
      return satiety;
   }

   /**
    * Переопределенный метод интерфейса EventPlateListener. Вызывает метод кормления кота
    *
    * @param plate Объект plate - Миска с едой/без еды
    */
   @Override
   public void update(Plate plate) {
      eat(plate);    // Вызов метода кормления кота
   }
}
