<%--
  Created by IntelliJ IDEA.
  User: HY
  Date: 2020/2/5
  Time: 15:22
  在listOrderItem.jsp中，从session中遍历出所有的OrderItem。
  因为保存在OrderItem 上的是一个Product对象，所以很容易就可以通过EL表达式遍历出商品的名称和价格
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
         language="java" import="java.util.*" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1 align="center">购物车</h1>
    <table algin="center" border="1" cellspacing="0">
        <tr>
            <td>商品名称</td>
            <td>单价</td>
            <td>数量</td>
            <td>小计</td>
        </tr>

        <c:forEach items="${ois}" var="oi" varStatus="st">
            <tr>
                <td>${oi.product.name}</td>
                <td>${oi.product.price}</td>
                <td>${oi.num}</td>
                <td>${oi.product.price*oi.num}</td>
                <!--为每个订单项增加一个删除按钮-->
                <td>
                <form action="deleteOrderItem" method="post">
                    <input type="hidden" name="pid" value="${oi.product.id}">
                    <input type="submit" value="删除">
                </form>
                </td>
            </tr>
        </c:forEach>
        <!--新增一个生成订单的链接-->
        <c:if test="${!empty ois}">
            <tr>
                <td colspan="4" align="right">
                    <a href="createOrder">生成订单</a>
                </td>
            </tr>
        </c:if>
    </table>
</body>
</html>
