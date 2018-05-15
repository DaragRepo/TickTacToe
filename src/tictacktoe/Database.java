/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacktoe;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author moh
 */
public class Database {

    private String db_url;
    private String db_user;
    private String db_pass;
    private Connection conn;
    private String table_name;

    // establish the Database Connection 
    public Database(String db_url, String db_user, String db_pass, String table_name) throws SQLException {
        this.db_url = db_url;
        this.db_user = db_user;
        this.db_pass = db_pass;
        this.table_name = table_name;
        this.conn = DriverManager.getConnection(this.db_url, this.db_user, this.db_pass);
    }

    // insert into the Database 
    // 
    public boolean insert(String... s) {

        try {

//            String sql = "INSERT INTO employee (name) VALUES (?)";
            String sql = "INSERT INTO " + table_name + " (" + getTableColumns() + ") " + " VALUES " + " ( " + questionMarkGenerator(s.length) + " ) ";

            PreparedStatement statement = this.conn.prepareStatement(sql);
            statementGenerator(statement, s);
//            statement.setString(1, name);

//            String sql2 = "SELECT name FROM employee WHERE name=?";
//            String sql2 = "SELECT id FROM "+ ;
//            PreparedStatement ps = conn.prepareStatement(sql2);
//            ps.setString(1, name);
//            ResultSet rs = ps.executeQuery();
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
               return true ;

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return false ;
    }

    public ArrayList<String> select() throws SQLException {
        String sql = "SELECT * FROM " + table_name;
        ArrayList<String> data = new ArrayList();
        Statement statement = this.conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int numColumns = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= numColumns; i++) {
                data.add((String.valueOf(rs.getObject(i))));
            }
        }
        return data;
    }

    public boolean selectLogin(String email, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE email='" + email + "' && password='" + password + "'";
        String dbEmail = "";
        String dbPassword = "";
        Statement statement = this.conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        ArrayList<String> data = new ArrayList();
        while (rs.next()) {
            dbEmail = rs.getString("email");
            dbPassword = rs.getString("password");
        }
        if (email.equals(dbEmail) && password.equals(dbPassword)) {
            return true;
        }
        return false;
    }

    public ArrayList<String> selectRecord(int player_1 , int player_2) throws SQLException {
        String sql = "SELECT winner FROM record WHERE player_1 = " + player_1 +  " OR player_2 = "+player_2;
         ArrayList<String> data = new ArrayList();

        Statement statement = this.conn.createStatement();
        ResultSet rs= statement.executeQuery(sql);
       while (rs.next()) {
            int numColumns = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= numColumns; i++) {
                data.add((String.valueOf(rs.getObject(i))));
            }
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
//        String sql = "DELETE FROM employee WHERE id=?";
        String sql = "DELETE FROM " + table_name + " WHERE id=? ";

        PreparedStatement statement = this.conn.prepareStatement(sql);
        statement.setString(1, String.valueOf(id));

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
        }

    }

    private static String coma(String s) {
        String comma = s.replaceAll("\\s", ",");
        return comma;
    }

    private static String questionMarkGenerator(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                s += "?";
            } else {
                s += "?" + ",";
            }

        }
        return s;
    }

    private static void statementGenerator(PreparedStatement ps, String[] s) throws SQLException {
        int c1 = 1;
        for (int i = 0; i < s.length; i++) {
            ps.setString(c1, s[i]);
            c1++;
        }

    }

    public String getTableColumns() throws SQLException {
        DatabaseMetaData databaseMetaData = conn.getMetaData();
        ResultSet columns = databaseMetaData.getColumns(null, null, this.table_name, null);
        String data = "";
        while (columns.next()) {
            String name = columns.getString(4) + " ";
            data += name;

        }
        if (data.contains("id")) {
            data = data.substring(3, data.length() - 1);
        }
        data = coma(data);
        return data;
    }

}
