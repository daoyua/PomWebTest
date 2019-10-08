package com.test.server;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

public class DBCPdemo {
    @Test
    public void testDBCP() throws Exception {
        Properties   properties = new Properties();
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        BasicDataSourceFactory basicDataSourceFactory=new BasicDataSourceFactory();
        DataSource dataSource = basicDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();

//        String url = "select * from student ";
//        PreparedStatement preparedStatement = connection.prepareStatement(url);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        System.out.println(resultSet.toString());
//        preparedStatement.close();
//        connection.close();
    }
}
