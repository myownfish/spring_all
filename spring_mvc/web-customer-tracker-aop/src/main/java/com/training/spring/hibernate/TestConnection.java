package com.training.spring.hibernate;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;

public class TestConnection {

    public static void main(String[] args)  {
 
        String user = "springstudent";
        String pass = "springstudent";
        
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";
        
        try {

            PrintStream out = System.out;
            out.println("Connecting to database: " + jdbcUrl);
            Class.forName(driver);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            out.println("SUCCESS!!" );
            myConn.close();
        } catch(Exception exc) {
            exc.printStackTrace();
        }
    }

}
