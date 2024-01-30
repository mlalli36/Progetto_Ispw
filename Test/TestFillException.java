import com.example.progetto_ispw.fillform.FillFormBean;
import com.example.progetto_ispw.fillform.FillFormController;
import com.example.progetto_ispw.fillform.exception.TimeAlreadySelectedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//Author: Pamela Longo
public class TestFillException {

        @Test
        void testFill_SuccessfulAppointment() {
            /* In questo test case vogliamo verificare che sia corretta la gestione dell'eccezione in cui venga trovato un appuntamento già inserito per la data scelta dall'utente.
             */
            FillFormController controller = new FillFormController();
            FillFormBean bean = new FillFormBean();

            // Imposta il bean con dati validi
            bean.setEmailUser("pam@gmail.com");
            bean.setName("dido");
            bean.setSurname("dido");
            bean.setDescription("ciao sono io");
            bean.setPhone("555");
            bean.setEmailWorker("dido@gmail.com");
            bean.setDate("2024-01-25");
            bean.setTime("12:00");

            // Chiamata al metodo fill e verifica l'eccezione
            try {
                controller.fill(bean);
                // Se il test arriva a questo punto senza lanciare un'eccezione, il test fallisce
                fail("Expected TimeAlreadySelectedException not thrown");
            } catch (TimeAlreadySelectedException e) {
                // Il test passa se un'eccezione TimeAlreadySelectedException viene lanciata
                assertEquals("The selected time is no longer valid.", e.getMessage());
            }


        }
    }


