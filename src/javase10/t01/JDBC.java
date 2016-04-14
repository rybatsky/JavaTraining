package javase10.t01;

import java.sql.*;

/**
 * Created by rybatsky
 */

public class JDBC{

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.h2.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
             Statement statement = connection.createStatement()) {
            statement.addBatch("CREATE TABLE Person (id INT PRIMARY KEY, name VARCHAR(255))");
            statement.addBatch("INSERT INTO Person (id, name) VALUES (1,'name1')");
            statement.addBatch("INSERT INTO Person (id, name) VALUES (2,'name2')");
            statement.addBatch("INSERT INTO Person (id, name) VALUES (3,'name3')");
            statement.addBatch("INSERT INTO Person (id, name) VALUES (4,'name4')");
            statement.executeBatch();

            try (ResultSet rs = statement.executeQuery("SELECT * FROM Person")) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " + rs.getString("name"));
                }
            }

            statement.executeUpdate("UPDATE Person SET name ='name21' WHERE id = 2");
            statement.executeUpdate("UPDATE Person SET name ='name41' WHERE id = 4");

            System.out.println();
            try (ResultSet rs = statement.executeQuery("SELECT * FROM Person")) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " + rs.getString("name"));
                }
            }

            System.out.println();
            try (ResultSet rs = statement.executeQuery("SELECT * FROM Person WHERE id = 1")) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " + rs.getString("name"));
                }
            }

            statement.execute("DROP TABLE Person");
        }
    }
}
