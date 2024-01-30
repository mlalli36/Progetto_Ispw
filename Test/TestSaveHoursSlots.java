import com.example.progetto_ispw.savehoursslots.SaveHoursBean;
import com.example.progetto_ispw.savehoursslots.SaveHoursController;
import com.example.progetto_ispw.savehoursslots.exception.TimeSlotAlreadyExistsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


//Author: Pamela Longo
public class TestSaveHoursSlots {
   @Test
   public void testSaveHoursSlots() {


      SaveHoursController controller = new SaveHoursController();

      // Creazione di un oggetto SaveHoursBean con dati di input appropriati per il test
      SaveHoursBean bean = new SaveHoursBean();
      bean.setemail("fabio@gmail.com");
      bean.setSlot1("10:00");
      bean.setSlot2("10:01");
      bean.setSlot3("10:02");
      bean.setSlot4("10:03");
      bean.setSlot5("10:04");
      bean.setDateCalendar("2027-10-27");


      // Chiamata al metodo saveHoursSlots con il bean creato
      try {

         controller.saveHoursSlots(bean);
         // Se il test arriva a questo punto senza lanciare un'eccezione, il salvataggio è avvenuto correttamente
         System.out.println("Gli slot sono stati inseriti");

      } catch (TimeSlotAlreadyExistsException e) {
         // Se viene lanciata TimeSlotAlreadyExistsException:

        fail("Lo slot orario esiste già");
      }
   }

}









