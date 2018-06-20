package dao;

import java.sql.*;

import static util.DBUtil.getConnection;

/**
 * @author dailiwen
 * @date 2018/05/29
 */
public class BaseDao {

    public void execute(String sql) throws Exception {
        Connection connection = getConnection();
        //用于对数据库进行通用访问，在运行时使用静态SQL语句时很有用。 Statement接口不能接受参数。
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("连接数据库出错");
        }
        try {
            if (statement != null) {
                statement.execute(sql);
            }
        } catch (SQLException e) {
            System.out.println("连接数据库出错");
        }
    }

    public static ResultSet select(String sql) throws Exception {
        Connection connection = getConnection();
        //当计划要多次使用SQL语句时使用。PreparedStatement接口在运行时接受输入参数。
        PreparedStatement stmt = connection.prepareStatement(sql);
        //SQL语句执行后从数据库查询读取数据，返回的数据放在结果集中
        //executeQuery用于产生单个结果集的语句，例如 SELECT 语句
        return stmt.executeQuery(sql);
    }


}
