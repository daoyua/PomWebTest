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

public class TestDBUtilC3P0 {
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
    @Test
    public  void  executeQuery() throws SQLException, IllegalAccessException, InstantiationException {
        QueryRunner runner=new QueryRunner(comboPooledDataSource);

//        int update = runner.update("insert into stu values(?,null,?)", "zzzzzzz", "nv");
//        System.out.println(update);

//        int update = runner.update("delete from stu where id=?", 2);
//        System.out.println(update);

        int update = runner.update("update  stu set name=? where id=?", "hhhhhhh",5);

        System.out.println(update);

//查询一个的结果
//        Student query = runner.query("select * from stu where id =?", new BeanHandler<Student>(Student.class),2);
//        System.out.println(query.toString());

//查询多个的结果
        List<Student> query1 = runner.query("select * from stu ", new BeanListHandler<Student>(Student.class));
        System.out.println(query1.toString());
//        Student student = Student.class.newInstance();
//        最原始的
//        ArrayList<Student> query = runner.query("select * from stu ", new ResultSetHandler<ArrayList<Student>>() {
//            @Override
//            public ArrayList<Student> handle(ResultSet rs) throws SQLException {
//                ArrayList<Student> arrayList = new ArrayList<>();
//                while (rs.next()) {
//                    Student student = new Student();
//                    student.setName(rs.getString("name"));
//                    student.setSex(rs.getString("sex"));
//                    student.setId(rs.getInt("id"));
//                    arrayList.add(student);
//                }
//                return arrayList;
//            }
//        });
    }
}
