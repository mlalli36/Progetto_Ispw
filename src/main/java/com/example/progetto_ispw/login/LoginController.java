package com.example.progetto_ispw.login;

import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.login.exception.LoginFailedException;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.salt.ZeroSaltGenerator;


import java.util.Objects;

public class LoginController {

     public static final String ENCRYPTION_KEY ="ISPWPROJECTWORKERLINK2023";


     public void loginUser(LoginBean bean) throws UserNotFoundException, LoginFailedException {


         UserDAO dao = UserDAO.getInstance();

         dao.getUser(bean.getEmail());

         UserEntity user = UserEntity.getInstance();

         String decryptPassword = this.decryptPassword(user.getPassword());

         if (!Objects.equals(decryptPassword, bean.getPassword()))
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
        //stessa parola

        return encryptor.decrypt(psw);
    }
}
