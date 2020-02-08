<%--
  Created by IntelliJ IDEA.
  User: HY
  Date: 2020/2/2
  修改日期: 08/02/2020
  修改功能: 将"购买"修改为加入购物车,点击之后,"加入购物车"几个字变灰,不可点。
           当前页面也不跳转。通过Ajax把这个数据提交到后台,加入购物车
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
         language="java" import="java.util.*"%>
<!--需要导入jsl.jar和standard.jar包以下这行才不报错-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="/js/jquery.min.js"></script>

<script>
$(function(){

$("input.addCartButton").removeAttr("disabled");
$("input.addCartButton").click(function(){
    $(this).attr("disabled","disabled");
    var button = $(this);
    var pid = $(this).attr("pid");
    var number = $("input.number[pid="+pid+"]").val();
    var page = "/addOrderItem";
        $.get(
            page,
            {"num":number,"pid":pid},
            function(result){
                $("#addCartSuccessMessage").fadeIn(1200);
                $("#addCartSuccessMessage").fadeOut(1200,function(){
                    button.removeAttr("disabled");
                });
            }
        );
});
$("#addCartSuccessMessage").hide();
});
</script>

<html>
<head>
    <title>购物车</title>
</head>
<body>
    <c:if test="${!empty user}">
        <div align="center">
            当前用户: ${user.name}
        </div>
    </c:if>
    <table align="center" border="1" cellspacing="0">
        <tr>
            <td>id</td>
            <td>名称</td>
            <td>价格</td>
            <td>购买</td>
        </tr>
        <!--需要导入jsl.jar和standard.jar包forEach才不报错-->
        <c:forEach items="${products}" var="product" varStatus="st">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>
                         数量<input pid="${product.id}" class="number" type="text" value="1" name="num">
                    <input class="addCartButton" pid="${product.id}" type="submit" value="加入购物车">
                <!--
                <form action="addOrderItem" method="post">
                    数量<input type="text" value="1" name="num">
                    <input type="hidden" name="pid" value="${product.id}">
                    <input type="submit" value="购买">
                </form>  -->
                </td>
            </tr>
        </c:forEach>
        <!--增加查看购物车-->
        <tr>
            <td colspan="4"><a href="/listOrderItem">查看购物车</a></td>
        </tr>
    </table>
</body>
</html>
