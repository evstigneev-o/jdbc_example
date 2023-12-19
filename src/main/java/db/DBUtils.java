package db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static final Logger logger = LoggerFactory.getLogger(DBUtils.class);
   static String URL = "jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'classpath:init.sql'";
   static String USER = "sa";
   static String PASSWORD = "";

    public static Connection getConnection(){
        try{
            Connection connection = DriverManager.getConnection(URL,USER, PASSWORD);
            logger.info("Connection established");
            return connection;
        } catch (SQLException e){
            logger.error("Connection ERROR", e);
            throw new RuntimeException("Failed to establish connection", e);
        }
    }
}
