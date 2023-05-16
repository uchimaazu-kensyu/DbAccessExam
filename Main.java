import java.sql.*;

public class Main {

    public static void main(String[] args) {


        var ProductService = new ProductService();
        var productList = ProductService.findById(101);
        System.out.println(productList);

        var productList2 = ProductService.findByName("鉛筆");
        System.out.println(productList2);


        var productList3 = ProductService.insert(104,"消しゴム",100);
        System.out.println(productList3+"件追加");

        var productList4 = ProductService.update(104,"消しゴムゴム",1000);
        System.out.println(productList4 + "件更新");

        var productList5 = ProductService.delete(104);
        System.out.println(productList5 +"件消去");

    }
}