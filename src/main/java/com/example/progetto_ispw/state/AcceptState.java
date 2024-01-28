package com.example.progetto_ispw.state;

import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.notifications.NotificationsController;
import com.example.progetto_ispw.worker.WorkerDAO;

public class AcceptState implements AppointementState{

    @Override
    public void elaboraAppuntamento(NotificationsController context, String data, String orario, String email) throws UserNotFoundException {
        //logica per far accettare
        context.acceptMethod(data,orario,email);

    }
}
