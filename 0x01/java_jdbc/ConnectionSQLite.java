import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLite {

    private static final String URL = "jdbc:sqlite:sqlite_database_2022.db";

    public static void main(String[] args) {
        Connection();
    }

    public static void Connection() {
        try(Connection connection = DriverManager.getConnection(URL)) {
            System.out.println("Conexão estabelecida.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}