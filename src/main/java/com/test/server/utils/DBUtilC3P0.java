package com.test.server.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.test.server.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

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

//    public static void  executeQuery(String sql, Object[] params) {

    public  static int  executeUpdate(String sql,Object ... objects) throws SQLException {
        QueryRunner runner=new QueryRunner(comboPooledDataSource);
        int update = runner.update(sql, objects);
        String text;
        if(update==1){
            text="数据修改成功";
        }else
        {
            text="数据修改失败";
        }
        System.out.println(text);
        return update;
    }

   public  static <T>  List<T>  executeQuery(String sql,Class<T> tClass,Object ... objects) throws SQLException {
        QueryRunner runner=new QueryRunner(comboPooledDataSource);
        List<T> query1 = runner.query(sql, new BeanListHandler<>(tClass),objects);
        System.out.println(query1.toString());
        return query1;

    }

    @Test
    public  void  test() throws SQLException {
        int jjjjjjj = executeUpdate("update stu set name =? where id =?", "jjjjjjj", 5);
        System.out.println(jjjjjjj);

        List<Student> students = executeQuery("select * from stu", Student.class);
        System.out.println(students.toArray());
    }
}
