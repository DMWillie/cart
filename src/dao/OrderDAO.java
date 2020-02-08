package dao;
/*  Author: 北辰
    日期: 05/02/2020
    功能: OrderDAO把订单对象保存到数据库中。
这里需要注意的是，Order对象保存到数据库中后，该对象就会有对应的id，这个id，
在后续保存OrderItem的时候，是作为order id存在的。
所以在保存的数据库的时候，要获取自增长id
 */

import bean.Order;
import util.DBUtil;

import java.sql.*;

public class OrderDAO {

    public void insert(Order o){
        String sql = "insert into order_ values(null,?)";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ){
           ps.setInt(1,o.getUser().getId());
           ps.execute();
           //获取插入数据的自增长id
           ResultSet rs = ps.getGeneratedKeys();
           if(rs.next()){
               int id = rs.getInt(1);
               o.setId(id);
           }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
