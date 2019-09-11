package com.test.server.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.*;
import java.util.Properties;

import static com.test.server.utils.DBUtil.initMysql;

public class DBUtilC3P0 {
    private static Connection connection = null;
    private static Properties properties = null;
    private static ComboPooledDataSource comboPooledDataSource = null;
static {
     comboPooledDataSource=new ComboPooledDataSource();
}
    /**
     * 建立连接
     *
     * @return
     */
    public static Connection getConnection() throws SQLException {

        return comboPooledDataSource.getConnection();
    }

    /**
     * 关闭连接
     *
     * @param connection
     * @param statement
     * @param resultSet
     */
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
        closeAlls(connection, statement, resultSet);
    }

    static void closeAlls(Connection connection, Statement statement, ResultSet resultSet) {
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
            DBUtilC3P0.closeAll(connection, preparedStatement, null);
        }
        return num;
    }


    public static void  executeQuery(String sql, Object[] params) {
        QueryRunner runner=new QueryRunner(comboPooledDataSource);
    }
}
