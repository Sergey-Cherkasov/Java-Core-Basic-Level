package feedcats.notification;

import feedcats.models.Plate;

/**
 * Интерфейс слушателя
 */
public interface EventPlateListener {

   void update(Plate plate); //Описание метода обновления данных

}
