package com.my.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&Timezone=UTC";
        String user = "hbstudent";
        String password = "hbstudent";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("connection = " + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
