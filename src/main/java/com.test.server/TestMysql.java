package com.test.server;


import com.test.server.utils.DBUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class TestMysql {
    //    public static final String DRIVER="com.mysql.jdbc.Driver";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PAASSWORD = "zhouyang";

    public static void main(String[] args) throws Exception {
//        testMysql();

        testInserMysql();
        squeryMysqlUtil();
//        testPath();
        return;
    }

    private static void testInserMysql() {
        String []aas={"haha","jj"};
        DBUtil.executeUpdate("insert into stu(name,sex) values(?,?)",aas);
    }

    private static void squeryMysqlUtil() {
        StringBuilder stringBuilder=new StringBuilder();
        List<Map<String, Object>> maps = DBUtil.executeQuery("select * from stu", null);
        for (Map<String, Object> map:
             maps) {
            stringBuilder.append(map.keySet());
            stringBuilder.append(map.values());
        }
        System.out.println(stringBuilder.toString());
    }

    private static void testPath() throws IOException {
        Properties properties = new Properties();
//        properties.load(new FileInputStream("db.properties"));
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
//        file:/H:/developer/java/javaproject/PomWebTest/target/classes/
//        String path =contextClassLoader.getResource("").toString();
        InputStream resourceAsStream =contextClassLoader.getResourceAsStream("db.properties");
        properties.load(resourceAsStream);
        String mysqlUsername = properties.getProperty("mysqlUsername");
        System.out.println(mysqlUsername.toString());
    }

    private static void testMysql() throws ClassNotFoundException, SQLException {
        //1.注册驱动 反射技术,将驱动类加入到内容
        // 使用java.sql.DriverManager类静态方法 registerDriver(Driver driver)
        // Diver是一个接口,参数传递,MySQL驱动程序中的实现类
        //DriverManager.registerDriver(new Driver());
        //驱动类源代码,注册2次驱动程序
        Class.forName(DRIVER);

        //2.获得数据库连接  DriverManager类中静态方法
        //static Connection getConnection(String url, String user, String password)
        //返回值是Connection接口的实现类,在mysql驱动程序
        //url: 数据库地址  jdbc:mysql://连接主机IP:端口号//数据库名字
        Connection connection = DriverManager.getConnection(URL, USERNAME, PAASSWORD);

        //3.获得语句执行平台, 通过数据库连接对象,获取到SQL语句的执行者对象
        // con对象调用方法   Statement createStatement() 获取Statement对象,将SQL语句发送到数据库
        // 返回值是 Statement接口的实现类对象,,在mysql驱动程序
        String url = "select * from stu where id =?";
        String url1 = "insert into stu(name,sex) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(url);
        preparedStatement.setInt(1, 1);
//        preparedStatement.setString(2,"nan2");
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println(resultSet.toString());
        preparedStatement.close();
        connection.close();
    }
}
