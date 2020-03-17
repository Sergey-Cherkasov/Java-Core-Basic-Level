package feedcats.notification;

import feedcats.models.Cat;
import feedcats.models.Plate;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс базового издателя
 */
public class EventManager {

   List<Cat> catsSubscribeList = new ArrayList<>();

   public EventManager() {
   }

   /**
    * Метод подписки кота на состояние миски
    *
    * @param cat Объект класса Cat
    */
   public void subscribe(Cat cat) {
      catsSubscribeList.add(cat);   //Добавление кота в список подписчиков
   }

   /**
    * Метод отписки кота на состояние миски
    *
    * @param cat Объект класса Cat
    */
   public void unsubscribe(Cat cat) {
      catsSubscribeList.remove(cat);//Удаление кота из списка подписчиков
   }

   /**
    * Метод оповещения котов об изменении состояния миски
    *
    * @param plate Объект класса Plate - миска с едой/без еды
    */
   public void notify(Plate plate) {
      for (Cat cat : catsSubscribeList) {
         cat.update(plate);         //Информирование кота об изменение состояния миски
      }
   }
}
