package com.test.server.utils;

import java.sql.*;
import java.util.*;

public class DBUtil {
    private static Connection connection = null;
    private static Properties properties = null;

    /**
     * 建立连接
     *
     * @return
     */
    public static Connection getConnection() {
        properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
            Class.forName(properties.getProperty("mysqlDriver"));
            connection = DriverManager.getConnection(properties.getProperty("mysqlUrl"),
                    properties.getProperty("mysqlUsername"), properties.getProperty("mysqlPassword"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭连接
     *
     * @param connection
     * @param statement
     * @param resultSet
     */
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 增删改查
     *
     * @param sql
     * @param objects
     * @return
     */
    public static int executeUpdate(String sql, Object[] objects) {
        int num = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement= initMysql(sql,objects);

            num = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, preparedStatement, null);
        }
        return num;
    }
private static PreparedStatement initMysql(String sql, Object[] params) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    connection = DBUtil.getConnection();
    preparedStatement = connection.prepareStatement(sql);
    if (params != null && params.length != 0) {
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i+1, params[i]);
        }
    }
    return  preparedStatement;
}

    public static List<Map<String, Object>> executeQuery(String sql, Object[] params) {
        ResultSet res = null;
        PreparedStatement preparedStatement = null;
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            preparedStatement= initMysql(sql,params);
          res=  preparedStatement.executeQuery();
            ResultSetMetaData metaData = res.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (res.next()){
                Map<String,Object> map=new HashMap<>();
                for (int i = 0; i < columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i+1);
                    Object columnValue = res.getObject(i+1);
                    //System.out.println(columnName + "===>" + columnValue);
                    map.put(columnName, columnValue);
                }
                list.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, preparedStatement, null);
        }
        return list;
    }
}
