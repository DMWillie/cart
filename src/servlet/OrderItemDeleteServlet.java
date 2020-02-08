package servlet;
/*  Author: 北辰
    日期: 05/02/2020
    功能: 删除某个订单项
    删除订单项也是直接从session中的List中获取某个订单并删除,不用查询数据库,流程如下:
    1.获取订单项中的pid(产品id)
    2.获取session中的订单项集合
    3.遍历订单项集合,若该集合中某个订单的product.id和pid相同,则从集合中删除该订单
    4.跳转到显示购物车的listOrderItem页面
 */

import bean.OrderItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class OrderItemDeleteServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取订单项中的pid(产品id)
        int pid = Integer.parseInt(request.getParameter("pid"));
        //从session中获取订单项集合
        List<OrderItem> list = (List<OrderItem>)request.getSession().getAttribute("ois");
        //遍历集合根据pid来删除某个订单
        for(Iterator<OrderItem> it=list.iterator();it.hasNext();){
            OrderItem orderItem = it.next();
            if(orderItem.getProduct().getId()==pid){
                it.remove();
            }
        }
        //刷新页面,重定向到listOrderItem页
        response.sendRedirect("/listOrderItem");
    }
}
