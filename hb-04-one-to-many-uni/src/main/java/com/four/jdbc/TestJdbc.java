package com.four.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {

        String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            System.out.println("connecting to db: " + jdbcURL);

            Connection myConn =
                    DriverManager.getConnection(jdbcURL, user, pass);

            System.out.println("success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
