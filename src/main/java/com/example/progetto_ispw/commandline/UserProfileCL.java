package com.example.progetto_ispw.commandline;

import com.example.progetto_ispw.UIController;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.userprofile.UserProfileBean;
import com.example.progetto_ispw.userprofile.UserProfileController;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
/*
public class UserProfileCL {
    public void preCompileUser( String namesearch, String surnamesearch, String emailsearch) {
        out.println(""+namesearch);
        out.println(""+surnamesearch);
        out.println(""+emailsearch);
    }


   void choice() throws UserNotFoundException, IOException {
        int i ;
        out.println(

                        "1) Book service" +
                        "2) My details" +
                        "3) Change password" +
                        "4) Addresses" +
                        "5) Exit"+
                                "6) Home"+
                                "7) Profile"
        );
        Scanner input= new Scanner(in);
        while(true){
            out.println("Insert your choice: (1,2,3,4,5,6,7)");
            i= input.nextInt();
            if(i>=1 && i<=7){
                break;

            }else{
                out.println("Input not valid!");
            }
        }

       CLController clC=  CLController.getInstance();
       switch (i){
            case 1:
                UserEntity user=UserEntity.getInstance();

                String emailsearch= user.getEmail();
                UserProfileBean bean = new UserProfileBean();
                bean.setEmail(user.getEmail());
                UserProfileController controller =new UserProfileController();
                controller.searchInfo(bean);
                String namesearch= user.getName();
                String surnamesearch= user.getSurname();

                clC.showBookedServicesUserScreen(namesearch,surnamesearch,emailsearch);
                break;
            case 2:
                // not implemented
            case 3:
                // not implemented
            case 4:
                // not implemented
            case 5:
                clC.ExitScreen();

            case 6:
                clC.loadHomeScreen();
            case 7:
                clC.profileScreen();
            default:
                throw new IllegalStateException("Unexpected value: " + i);
        }
   }

}
*/