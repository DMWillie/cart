package bean;
/*  Author: 北辰
    日期: 05/02/2020
    功能: 订单Order类,对应数据库的order表，里面有一个uid字段用于表明该订单属于哪个用户
注： order是关键字，不能直接用作表名，通常的做法是加一个下划线order_
与OrderItem类似的，会有一个User属性，而不是使用int类型的uid
 */

public class Order {
    int id;
    User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
