package com.wifilocation.demo;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnectionTest {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://test.devsh.kro.kr:3306/wifilocation?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USER = "wifilocation";
    private static final String PASSWORD = "test";

    @Test
    public void testConnection() throws Exception{
        Class.forName(DRIVER);
        try{
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(connection);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
