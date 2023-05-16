import java.util.Collection;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    public static Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "test");
        } catch (Exception e1) {
            throw new RuntimeException();
        }

    }
}
