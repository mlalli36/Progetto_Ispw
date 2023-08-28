package com.example.progetto_ispw.commandline;

import com.example.progetto_ispw.user.UserEntity;

import java.util.Scanner;

import static java.lang.System.*;

public class HomeScreenCL {
    private static HomeScreenCL instance =null;
    private final UserEntity user = UserEntity.getInstance();

    private HomeScreenCL(){}

    public static  HomeScreenCL getInstance(){
        if(HomeScreenCL.instance==null) instance = new HomeScreenCL();
        return instance;
    }

    public void showCLHomeScreen(){
        int selectedOption;
        while((selectedOption = showOptions())<0){
            //esegui showOptions finché l'utente non sceglie un'opzione corretta o non termina il programma
        }
        switch(selectedOption){
            case 1:{
                     CLController c= CLController.getInstance();
                     c.showSearchScreen();
                     break;}

            case 2:{
                    CLController c = CLController.getInstance();
                    c.showProfileScreen();
                    break;
                   }
            case 3:{
                    System.exit(0);
                    break;
                }
            default:{/* Non è necessario gestire altri casi perché sono già gestiti dal ciclo while  */}
        }
        }


    private int showOptions(){
        out.println("""
                                        WELCOME TO WORKERLINK

                Select what you want to do (insert the number):
                
                1) Search the craftsman you need 
                2) Open your profile
                3) Quit application"""

);
        Scanner scanner = new Scanner(in);
        int selectedOption = scanner.nextInt();
        if(selectedOption >4 || selectedOption<1){
            err.println("Invalid option, try option!");
            return -1;
        }
 return selectedOption;   }

}
