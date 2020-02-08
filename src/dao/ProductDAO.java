package dao;
/*  Author: 北辰
    日期: 02/02/2020
    修改日期: 05/02/2020
    功能: ProductDAO提供对Product的查询
    新增功能: 根据id获取Product对象(因为购买的时候，提交到服务器的是pid, 而OrderItem类的
    product属性是一个Product类型,所以ProductDAO需要根据id获取Product对象)
 */

import bean.Product;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public static void main(String[] args) {
//        new ProductDAO();
        System.out.println(new ProductDAO().getProduct(1).getName());
    }
    //构造方法
    public ProductDAO(){
//        //初始化数据库加载驱动
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//        }catch(ClassNotFoundException e){
//            e.printStackTrace();
//        }
    }

    public List<Product> listProduct(){
        List<Product> products = new ArrayList<>();
        String sql = "select * from product order by id";
        try(Connection c = DBUtil.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)
                ){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");

                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                products.add(product);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    public Product getProduct(int id){
        Product result = null;
        String sql = "select * from product where id = ?";
        try(Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)
        ){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                result = new Product();
                result.setId(id);
                result.setName(rs.getString("name"));
                result.setPrice(rs.getFloat("price"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
