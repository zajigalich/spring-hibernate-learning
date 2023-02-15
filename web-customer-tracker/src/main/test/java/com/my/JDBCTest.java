package com.my;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.DriverManager;

public class JDBCTest {
    @Test
    public void connectionTest() {
        String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String password = "hbstudent";

        Assertions.assertDoesNotThrow(() -> {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.getConnection(url, user, password).close();
        });
    }
}
