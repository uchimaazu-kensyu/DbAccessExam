import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class ProductService {
    ProductDao dao;
    Connection connection;

    //コンストラクタないでConnectionを作成
    public ProductService() {


    }

    public ProductRecord findById(int id) {
        //データベース接続
        try {
            connection = DbUtil.getConnection();
            this.dao = new ProductDao(connection);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        //daoを呼び出して、結果をproductに入れる
        ProductRecord product = dao.findByID(id);

        //connectionをclose
        try {
            connection.close();
        }catch (RuntimeException | SQLException e){
            e.printStackTrace();
        }

        //結果をリターン
        return product;
    }

    public List<ProductRecord> findByName(String name){

        //データベース接続
        try {
            connection = DbUtil.getConnection();
            this.dao = new ProductDao(connection);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        List<ProductRecord> product = dao.findByName(name);

        //connectionをclose
        try {
            connection.close();
        }catch (RuntimeException | SQLException e){
            e.printStackTrace();
        }

        //結果をリターン
        return product;

    }


    public int insert(int id, String name,int price){

        //データベース接続
        try {
            connection = DbUtil.getConnection();
            this.dao = new ProductDao(connection);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        int number = dao.insert(id,name,price);

        //connectionをclose
        try {
            connection.close();
        }catch (RuntimeException | SQLException e){
            e.printStackTrace();
        }

        return number;
    }

    public int update(int id, String name,int price){

        //データベース接続
        try {
            connection = DbUtil.getConnection();
            this.dao = new ProductDao(connection);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }


        int number = dao.update(id,name,price);

        //connectionをclose
        try {
            connection.close();
        }catch (RuntimeException | SQLException e){
            e.printStackTrace();
        }

        return number;
    }

    public int delete(int id){
        //データベース接続
        try {
            connection = DbUtil.getConnection();
            this.dao = new ProductDao(connection);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }


        int number = dao.delete(id);

        //connectionをclose
        try {
            connection.close();
        }catch (RuntimeException | SQLException e){
            e.printStackTrace();
        }
        return number;
    }

}




