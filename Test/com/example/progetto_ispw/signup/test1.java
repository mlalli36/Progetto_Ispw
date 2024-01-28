package com.example.progetto_ispw.signup;

import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.signup.exception.DifferentPasswordException;
import com.example.progetto_ispw.signup.exception.UserAlreadyExistsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Author: Matteo Lalli
//Test per verificare se la mail sia già presente nel db nel momento della registrazione
class test1
{
    private final SignUpBean bean = new SignUpBean();
    private final SignUpController ctrl = new SignUpController();
    @Test
    void EmailIsAlreadyRegisteredTest() throws UserNotFoundException {
        int code = 0;

            bean.setEmail("supermario@gmail.com");
            bean.setPsw("piero");
            bean.setConfirmPsw("piero");

        try{
            ctrl.signUpUser(bean);
    } catch (DifferentPasswordException | UserAlreadyExistsException e){ code =1;}
        assertEquals(0,code);
    }


}