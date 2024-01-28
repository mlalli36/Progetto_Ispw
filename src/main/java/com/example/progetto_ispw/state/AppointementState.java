package com.example.progetto_ispw.state;

import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.notifications.NotificationsController;

public interface AppointementState {
    void elaboraAppuntamento(NotificationsController context, String data, String orario, String email) throws UserNotFoundException;
}
