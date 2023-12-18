package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
   static String URL = "jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'classpath:init.sql'";
   static String USER = "sa";
   static String PASSWORD = "";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL,USER, PASSWORD);
            System.out.println("Connection OK");
        } catch (SQLException e){
            System.out.println("Connection ERROR");
        }
        return connection;
    }
}
