package com.example.progetto_ispw.login;

import com.example.progetto_ispw.User.UserDAO;
import com.example.progetto_ispw.User.UserEntity;
import com.example.progetto_ispw.login.exception.LoginFailedException;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.salt.ZeroSaltGenerator;


import java.util.Objects;

import static java.lang.System.out;

public class LoginController {

     public static final String ENCRYPTION_KEY ="ISPWPROJECTWORKERLINK2023";


     public void loginUser(LoginBean bean) throws UserNotFoundException, LoginFailedException {


         UserDAO dao = UserDAO.getInstance();

         dao.getUser(bean.getEmail());
         UserEntity user = UserEntity.getInstance();

         String decryptedPassword = this.decryptPassword(user.getPassword());
           System.out.println(decryptedPassword);
           System.out.println(bean.getPassword());   // controllo delle password a schermo eliminare poi

         if (!Objects.equals(decryptedPassword, bean.getPassword()))
             throw new LoginFailedException("The password is incorrect");

     }



    private String decryptPassword(String psw) {
        //Viene passata la stringa criptata della password e non l'istanza
        //dell'user così il metodo non deve conoscere come è realizzata la
        //classe user

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(ENCRYPTION_KEY); //chiave per criptare la psw
        encryptor.setSaltGenerator(new ZeroSaltGenerator());

        //Non utilizzare salt per l'encryption, così da avere
        //risultati uguali ogni volta che si cripta e decripta la
        //la stessa parola

        return encryptor.decrypt(psw);
    }
}
