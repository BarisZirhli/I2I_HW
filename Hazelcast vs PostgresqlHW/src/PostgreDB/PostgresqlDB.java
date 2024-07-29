package PostgreDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresqlDB {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/i2i";
        String user = "postgres";
        String password = "mitaka";

        Connection connection = null;

        try {

            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Connected Succesfully Database!");
            }

            String deleteQuery = "DELETE FROM values";
            Statement deleteStatement = connection.createStatement();
            deleteStatement.executeUpdate(deleteQuery);
            deleteStatement.close();

            long startTime = System.nanoTime();
            String insertQuery = "INSERT INTO values (value) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            for (int i = 1; i <= 10000; i++) {
              preparedStatement.setInt(1, (int) (Math.random() * 5) + 1);
                preparedStatement.executeUpdate();
            }

            preparedStatement.close();
            long endTime = System.nanoTime();
            System.out.println("Putting Time 1-10,000: " + (endTime - startTime) / 1_000_000.0 + " ms");

            String selectQuery = "SELECT value FROM values";
            Statement selectStatement = connection.createStatement();
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            startTime = System.nanoTime();
            while (resultSet.next()) {
                resultSet.getInt("value");

            }
            resultSet.close();
            selectStatement.close();
            endTime = System.nanoTime();
            System.out.println("Getting Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Not Found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database Connecting Failure");
            e.printStackTrace();
        } finally {

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
