
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.signup.SignUpBean;
import com.example.progetto_ispw.signup.SignUpController;
import com.example.progetto_ispw.signup.exception.DifferentPasswordException;
import com.example.progetto_ispw.signup.exception.UserAlreadyExistsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Author: Matteo Lalli
public class test2 {
    private final SignUpController ctrl = new SignUpController();
    private final SignUpBean bean = new SignUpBean();

    @Test
    void UserRegistrationTest() throws UserNotFoundException {
        int code = 0 ;
        bean.setEmail("irene@gmail.com");
        bean.setPsw("1234");
        bean.setConfirmPsw("1234");
        bean.setName("irene");
        bean.setSurname("bart");

        try{
            ctrl.signUpUser(bean);
            ctrl.searchInfo(bean);
        }catch (Exception e){
            code = 1;
        }
        assertEquals(0,code);
    }
}
