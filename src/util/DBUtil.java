package util;

/*  Author: 北辰
    日期: 29/01/2020
    功能: 通常来讲，在一个基于JDBC开发的项目里，都会有一个DBUtil这么一个类，
    在这个类里统一提供连接数据库的IP地址，端口，数据库名称， 账号，密码，编码方式等信息。
    如例所示，在这个DBUtil类里，这些信息，就是以属性的方式定义在类里的
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    static String ip = "127.0.0.1";
    static int port = 3306;
    static String database = "cart";
    static String encoding = "UTF-8";
    static String loginName = "root";
    static String password = "admin";
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s",
                ip,port,database,encoding);
        return DriverManager.getConnection(url,loginName,password);
    }

    public static void main(String[] args) throws SQLException{
        System.out.println(getConnection());
    }
}

