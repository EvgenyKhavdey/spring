package gb.khavdey.hw5;

import java.sql.*;

/**
 * @author antonkuznetsov
 */
public class JDBCExample {

    public static void main(String[] args) throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=hiber", "postgres", "admin");
             Statement statement = con.createStatement()) {
            final ResultSet resultSet = statement.executeQuery("SELECT 1");
            if (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
        }
    }
}
