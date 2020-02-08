package dao;
/*  Author: 北辰
    日期: 05/02/2020
    功能: 将OrderItem保存到数据库中
 */

import bean.OrderItem;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderItemDAO {

    public void insert(OrderItem oi){
        String sql = "insert into orderitem values(null,?,?,?)";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)
        ){
            ps.setInt(1,oi.getProduct().getId());
            ps.setInt(2,oi.getNum());
            ps.setInt(3,oi.getOrder().getId());
            ps.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
