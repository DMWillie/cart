package bean;
/*  Author: 北辰
    日期: 05/02/2020
    功能: 从开发者的角度来看，购买行为 就是创建一条一条的订单项
而显示购物车，也就是把这些订单项显示在页面上。
在这个阶段，订单项都会保存在session中，直到最后生成订单的时候，才会把这些订单项保存在数据库中
OrderItem使用属性Product类型的product，而非int类型的pid，
因为在后续显示购物车的时候，可以很简单的通过el表达式就显示商品名称和价格了
 */

public class OrderItem {
    private int id;
    private Product product;
    private int num;
    //OrderItem在原来的基础上，增加一个Order属性
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
