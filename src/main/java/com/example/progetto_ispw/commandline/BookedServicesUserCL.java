package com.example.progetto_ispw.commandline;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.bookedServicesUser.BookedServicesUserBean;
import com.example.progetto_ispw.bookedServicesUser.BookedServicesUserController;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.userprofile.UserTilePane;
import com.example.progetto_ispw.workerprofile.AppointmentResultElement;
import com.example.progetto_ispw.workerprofile.AppointmentResultEntity;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
/*
public class BookedServicesUserCL {
    public void precompileUser(String namesearch, String surnamesearch, String emailsearch) {
            out.println(""+namesearch);
            out.println(""+surnamesearch);
            out.println(""+emailsearch);
    }

    public void bookServicesMethod() {

        UserEntity uE = UserEntity.getInstance();
        String email = uE.getEmail();
        BookedServicesUserBean bean = new BookedServicesUserBean();
        bean.setEmail(email);
        BookedServicesUserController ctrl = new BookedServicesUserController();
        if (ctrl.verifica(bean)) {
            AppointmentResultEntity appointmentResultEntity = bean.getAppointmentResultSet();
          int i=0;
          int c=0;
            for (AppointmentResultElement a : appointmentResultEntity.getElements()) {
                i++;
                c++;
                String email_client = a.getCEmail();
                String name_client = a.getCName();
                String surname_client = a.getCSurname();
                String phone_client = a.getCNumber();
                String description_work = a.getdescriptionWork();
                String time = a.getTime();
                String date = a.getDAppo();
                String email_worker = a.getWEmail();


                out.println(""+i+
                            ""+email_client+
                            ""+name_client+
                            ""+surname_client+
                            ""+phone_client+
                            ""+description_work+
                            ""+time+
                            ""+date+
                            ""+email_worker

                );

                Scanner scanner= new Scanner(in);
                while(true) {
                    out.println("Insert a value to delete appointement: (1,2...)");
                    int value= scanner.nextInt();
                    if (value >= 0 && value <= c) {

                        BookedServicesUserController controller = new BookedServicesUserController();
                        controller.deleteAppoU(email_client, date, time);
                    } else {
                        out.println("Input not valid!");
                    }
                }
               /* userTilePane.addElements(deleteButton, name_client, surname_client, email_client, description_work, phone_client, date, time, email_worker);

                deleteButton.setOnAction(event -> {

                    BookedServicesUserController controller = new BookedServicesUserController();
                    controller.deleteAppoU(email_client, date, time);

                    UIController viewController = UIController.getUIControllerInstance();//è singletone

                    String emailsearch= uE.getEmail();


                    try {
                        controller.searchInfo(bean);
                    } catch (UserNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    String namesearch= uE.getName();
                    String surnamesearch= uE.getSurname();
                    try {
                        viewController.showBookedServicesUser(namesearch,surnamesearch,emailsearch);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                });




            }
            this.scrollPane.setContent(userTilePane.getUserTP());

        } else {
            noAppointmentText.setOpacity(1);
        }


            }
        }
    }
}
*/