package servlet;
/*  Author: 北辰
    日期: 02/02/2020
    功能: ProductListServlet的作用是通过ProductDAO把product从数据库中查询出来,
            然后通过listProduct.jsp显示出来
 */

import bean.Product;
import dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductListServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        List<Product> products = new ProductDAO().listProduct();
        request.setAttribute("products",products);
        request.getRequestDispatcher("listProduct.jsp").forward(request,response);
    }
}