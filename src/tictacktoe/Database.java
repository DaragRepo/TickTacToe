/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacktoe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author moh
 */
public class Database {

    private String db_url;
    private String db_user;
    private String db_pass;
    private Connection conn;

    public Database(String db_url, String db_user, String db_pass) throws SQLException {
        this.db_url = db_url;
        this.db_user = db_user;
        this.db_pass = db_pass;
        this.conn = DriverManager.getConnection(this.db_url, this.db_user, this.db_pass);
    }

    public void insert(String name) {

        try {

            String sql = "INSERT INTO employee (name) VALUES (?)";

            PreparedStatement statement = this.conn.prepareStatement(sql);
            statement.setString(1, name);

            String sql2 = "SELECT name FROM employee WHERE name=?";

            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new Record was inserted successfully!");

                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public String select() throws SQLException {
        String sql = "SELECT name FROM employee";

        Statement statement = this.conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        String data = "";
        while (result.next()) {
            String name = result.getString(1);
            data += "Employee Name : " + name + "\n";

        }
        return data;
    }

    public void update(String name) throws SQLException {
        String sql = "UPDATE employee SET name=? WHERE id=?";

        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, name);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM employee WHERE id=?";

        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, String.valueOf(id));

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
        }

    }

}
