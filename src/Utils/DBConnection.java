/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.Customer;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDateTime;
import javafx.stage.Stage;


/**
 *
 * @author cfonseca
 */
public class DBConnection {

    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://52.206.157.109/U005XW";
    static String user = "U005XW";
    static String pass = "53687115318";
    static Stage stage;
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    static PreparedStatement pstmt;

    public static Connection dbConnect() throws ClassNotFoundException, SQLException {
        conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }

    public static void dbExecute(String query) throws ClassNotFoundException, SQLException {
        conn = DriverManager.getConnection(url, user, pass);
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);
    }

    public static Boolean loginAuth(String u, String p) throws ClassNotFoundException, SQLException, IOException {
            conn = dbConnect();
            pstmt = conn.prepareStatement("SELECT * FROM user WHERE userName = ?");
            pstmt.setString(1, u);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return p.equals(rs.getString("password"));
            }
            return false;
        }
    
    public static void addCustomer() throws ClassNotFoundException, SQLException{
        conn = dbConnect();
        pstmt = conn.prepareStatement("INSERT INTO customer "
                + "(customerId, customerName, addressId, active, createDate, createdBy, lastUpdate, lastUpdateBy)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, 1);
            pstmt.setString(2, "addTest");
            pstmt.setInt(3, 1);
            pstmt.setInt(4, 1);
            pstmt.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            pstmt.setString(6, "test");
            pstmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            pstmt.setString(8, "test");
        pstmt.executeUpdate();
    }
}
