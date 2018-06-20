package dao;

import entity.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * @author dailiwen
 * @date 2018/05/29
 */
public class AccountDao extends BaseDao{
    private static AccountDao accountDao;

    public static AccountDao getAccountDao() {
        if (accountDao == null) {
            accountDao = new AccountDao();
        }
        return accountDao;
    }

    public Boolean login(String name, String password) throws Exception {
        String sql = "SELECT name,password FROM account WHERE name = '" + name + "' AND password = '" + password + "'";
        Account account = new Account();
        //executeQuery用于产生单个结果集的语句，例如 SELECT 语句
        ResultSet rs = select(sql);
        //getMetaData()得到结果集的结构
        ResultSetMetaData data = rs.getMetaData();
        //以一行一行为循环
        while (rs.next()) {
            //i必须从1开始，为第一列的意思
            for (int i = 1; i <= data.getColumnCount(); i++) {
                // 获得指定列的列值
                String columnValue = rs.getString(i);
                switch (i) {
                    case 1: {
                        account.setName(columnValue);
                        break;
                    }
                    case 2: {
                        account.setPassword(columnValue);
                        break;
                    }
                }
            }
        }
        if (account.getName() == null || account.getPassword() == null) {
            return false;
        } else {
            return true;
        }
    }


}
