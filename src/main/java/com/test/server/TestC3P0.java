package com.test.server;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestC3P0 {
    @Test
    public void TestC3P() throws SQLException {
        ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();
//        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
//        comboPooledDataSource.setProperties();
        Connection connection = comboPooledDataSource.getConnection();

        String url = "select * from student ";
//        String url1 = "insert into stu(name,sex) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(url);
//        preparedStatement.setInt(1, 1);
//        preparedStatement.setString(2,"nan2");
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println(resultSet.toString());
        preparedStatement.close();
        connection.close();


    }
}
