import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDao {
    //コネクションを持つためのフィールド
    final private Connection connection;

    //コンストラクタ
    public ProductDao(Connection connection) {
        this.connection = connection;
    }

    public ProductRecord findByID(int id){
        final var SQL = "SELECT * FROM products WHERE id = ?";
        ProductRecord product = null;

        try(PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                product = new ProductRecord(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(product == null){
            throw new ProductNotFoundException();
        }else{
            return product;
        }


    }


    public List<ProductRecord> findByName(String name){
        final var SQL = "SELECT * FROM products WHERE name = ? ";
        List<ProductRecord> products = new ArrayList<ProductRecord>();

        try(PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            stmt.setString(1,name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProductRecord result = new ProductRecord(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
                products.add(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    public int insert(int id, String name, int price){
        final var SQL = "INSERT INTO products VALUES (?,?,?)";
        int rs ;

        try(PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            stmt.setInt(1,id);
            stmt.setString(2,name);
            stmt.setInt(3,price);

            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return rs;
    }

    public int update(int id, String name, int price){
        final var SQL = "UPDATE products SET name =? ,price = ? WHERE id =?";
        int rs ;

        try(PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            stmt.setString(1,name);
            stmt.setInt(2,price);
            stmt.setInt(3,id);

            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return rs;
    }

    public int delete(int id){
        final var SQL = "DELETE FROM products WHERE id = ?";
        int rs ;

        try(PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            stmt.setInt(1,id);
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return rs;
    }



}




