package com.my.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hb_02_one_to_many?useSSL=false&Timezone=UTC";
        String user = "hbstudent";
        String password = "hbstudent";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection is successful: " + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
