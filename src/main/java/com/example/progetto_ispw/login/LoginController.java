package com.example.progetto_ispw.login;

import com.example.progetto_ispw.user.UserDAO;
import com.example.progetto_ispw.user.UserEntity;
import com.example.progetto_ispw.login.exception.LoginFailedException;
import com.example.progetto_ispw.login.exception.UserNotFoundException;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.salt.ZeroSaltGenerator;


import java.util.Objects;

public class LoginController {

     public static final String ENCRYPTION_KEY =System.getProperty("p.key");


     public void loginUser(LoginBean bean) throws UserNotFoundException, LoginFailedException {


         UserDAO dao = UserDAO.getInstance();

         dao.getUser(bean.getEmail());

         UserEntity user = UserEntity.getInstance();

         String decryptPassword = this.decryptPassword(user.getPassword());



         if (!Objects.equals(decryptPassword, bean.getPassword()))
             throw new LoginFailedException("The password is incorrect");

     }



    private String decryptPassword(String psw) {

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(ENCRYPTION_KEY);
        encryptor.setSaltGenerator(new ZeroSaltGenerator());

        return encryptor.decrypt(psw);
    }
}
