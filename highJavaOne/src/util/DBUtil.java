package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Teacher;

/**
 * 连接数据库工具类
 * @author dailiwen
 * @date 2018/05/17
 */
public class DBUtil {
    public static Connection getConnection() throws Exception {
        //com.mysql.jdbc.Driver为Mysql驱动名
        //用了最新的mysql连接驱动,按照最新官方提示支持将com.mysql.jdbc.Driver  改为  com.mysql.cj.jdbc.Driver,
        String driverName = "com.mysql.cj.jdbc.Driver";
        //你需要显式禁用SSL设置usessl = false提供服务器证书验证信任库
        String url = "jdbc:mysql://localhost:3306/java?useSSL=false";
        String userName = "root";
        String userPWD = "123456";

        //将驱动程序的类文件动态加载到内存中，并将其自动注册
        Class.forName(driverName);

        //要求传递数据库URL，用户名和密码：
        Connection connection = DriverManager.getConnection(url,userName,userPWD);

        return connection;
    }

    public static List<Teacher> select(String sql) throws Exception {
        List<Teacher> teachers = new ArrayList<>();
        int count = 0;
        Connection conn = getConnection();
        //当计划要多次使用SQL语句时使用。PreparedStatement接口在运行时接受输入参数。
        PreparedStatement stmt = conn.prepareStatement(sql);
        //SQL语句执行后从数据库查询读取数据，返回的数据放在结果集中
        //executeQuery用于产生单个结果集的语句，例如 SELECT 语句
        ResultSet rs = stmt.executeQuery(sql);
        //getMetaData()得到结果集的结构
        ResultSetMetaData data = rs.getMetaData();
        //以一行一行为循环
        while (rs.next()) {
            Teacher teacher = new Teacher();
            //i必须从1开始，为第一列的意思
            for (int i = 1; i <= data.getColumnCount(); i++) {
                // 获得指定列的列值
                String columnValue = rs.getString(i);
                switch (i) {
                    case 1: {
                        teacher.setId(columnValue);
                        break;
                    }
                    case 2: {
                        teacher.setName(columnValue);
                        break;
                    }
                    case 3: {
                        teacher.setSex(columnValue);
                        break;
                    }
                    case 4: {
                        teacher.setBirthday(columnValue);
                        break;
                    }
                    case 5: {
                        teacher.setSalary(Float.valueOf(columnValue));
                        break;
                    }
                    case 6: {
                        teacher.setCollege(columnValue);
                        break;
                    }
                    case 7: {
                        teacher.setMajoy(columnValue);
                        break;
                    }
                }
            }
            teachers.add(teacher);
        }
        return teachers;
    }


    public static boolean execute(String sql) throws Exception {
        Connection connection = getConnection();

        //用于对数据库进行通用访问，在运行时使用静态SQL语句时很有用。 Statement接口不能接受参数。
        Statement statement =  connection.createStatement();

        return statement.execute(sql);
    }
}
