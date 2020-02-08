package servlet;
/*  Author: 北辰
    日期: 04/02/2020
    功能: 登陆Servlet， 通过name和password获取user对象
如果对象不为空，就表示账号密码正确，跳转到产品显示界面 /listProduct
如果对象为空，就跳转到登陆界面，重新登陆
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import bean.User;
import dao.UserDAO;

public class UserLoginServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new UserDAO().getUser(name,password);
        if(null!=user){
            request.getSession().setAttribute("user",user);
            response.sendRedirect("/listProduct");
        }else{
            response.sendRedirect("/login.jsp");
        }
    }


}
