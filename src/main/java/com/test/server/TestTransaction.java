package com.test.server;

import com.test.server.utils.DBUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestTransaction {

    private Connection connection;

    @Test
    public void testTransaction(){
        try {

            String sql="update stu set name =?where id=?";
            StringBuilder stringBuilder=new StringBuilder();
            Object []ss={"hhhhhh",2};
            connection = DBUtil.getConnection();
            //不自动提交
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,"zhouzhouzhou");
            preparedStatement.setObject(2,2);
            preparedStatement.executeUpdate();

            preparedStatement.setObject(1,"zhouzhouzhou");
            preparedStatement.setObject(2,3);
            preparedStatement.executeUpdate();

            connection.commit();
            TestMysql.squeryMysqlUtil();
        }catch (Exception e){
            try {
                //回滚
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

//        System.out.println(stringBuilder.toString());
    }
}
