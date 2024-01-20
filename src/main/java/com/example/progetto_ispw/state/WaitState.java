package com.example.progetto_ispw.state;

import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.notifications.NotificationsController;

public class WaitState implements AppointementState{
    @Override
    public void elaboraAppuntamento(NotificationsController context,String data, String orario, String email) throws UserNotFoundException {
        //logica per fare cose impletare
        context.deleteAppo(data,orario,email);
    }
}

