package dao;
/*  Author: 北辰
    日期: 04/02/2020
    功能: 根据name和password查询表user,如果有数据就表示账号密码正确
 */

import bean.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static void main(String[] args) {
        System.out.println(new UserDAO().getUser("tom","123").getId());
    }

    public User getUser(String name,String password){
        User result = null;
        String sql = "select * from user where name=? and password=?";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)
                ){
            ps.setString(1,name);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                result = new User();
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("name"));
                result.setPassword(rs.getString("password"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
