package com.example.progetto_ispw.utile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class DBConnector {

    private static Connection con = null;

    public static Connection getConnector() throws SQLException {
        if (con != null && !DBConnector.con.isClosed() && DBConnector.con.isValid(0))
            return DBConnector.con;
        else {
            try {
                Objects.requireNonNull(con).close();
            } catch (SQLException | NullPointerException e) {
                //connection was already closed
            }
        }

        try (InputStream input = new FileInputStream("src/main/resources/com/example/progetto_ispw/Database/Databaseinfo.properties")) {

            Properties prop = new Properties();

             prop.load(input);
             con = DriverManager.getConnection(prop.getProperty("db.url"), prop.getProperty("db.user"), prop.getProperty("db.psw"));


        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return con;
    }

    private DBConnector() {
    }  

}
