/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.stage.Stage;
import Model.Customer;
import java.util.ArrayList;
import static Utils.TempDBCustomer.*;

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
    static PreparedStatement pstmt2;

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
    public static ArrayList<Customer> customerListDB = new ArrayList();
    public static final Object lock = new Object();

    public static Customer searchCustomer(String name) throws ClassNotFoundException, SQLException {
        conn = dbConnect();
        pstmt = conn.prepareStatement("SELECT * FROM customer "
                + "JOIN address "
                + "ON customer.customerId = address.addressId "
                + "WHERE customer.customerName = ?");
        pstmt.setString(1, name);
        rs = pstmt.executeQuery();
        Customer temp = new Customer();
        if (rs != null) {
            temp = tempCustomer(rs);
        } else {
            System.out.println("CUSTOMER NOT FOUND.");
        }
        return temp;
    }

    public static void getCustomers() throws ClassNotFoundException, SQLException {
        conn = dbConnect();
        pstmt = conn.prepareStatement("SELECT * from customer JOIN address ON customer.customerId = address.addressId ");
        rs = pstmt.executeQuery();
        while (rs.next()) {
            synchronized (lock) {
                Customer temp = tempCustomer(rs);
                customerListDB.add(temp);
            }
        }
    }

    public static void addCustomerToDB(Customer c) throws ClassNotFoundException, SQLException {
        conn = dbConnect();
        String check = "SELECT * FROM customer WHERE customerName = ?";
        pstmt = conn.prepareStatement(check);
        pstmt.setString(1, c.getCustomerName());
        rs = pstmt.executeQuery();
        if (rs.next()) {
            AlertDiag.loginError();
        } else {
            synchronized (lock) {
                pstmt = conn.prepareStatement("INSERT INTO customer "
                        + "(customerId, customerName, addressId, active, "
                        + "createDate, createdBy, lastUpdateBy)"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)");

                pstmt2 = conn.prepareStatement("INSERT INTO address "
                        + "(address, address2, cityId, postalCode, "
                        + "phone, createDate, createdBy, lastUpdateBy)"
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

                pstmt.setInt(1, c.getId());
                pstmt.setString(2, c.getCustomerName());
                pstmt.setInt(3, c.getAddressId());
                pstmt.setInt(4, c.getActive());
                pstmt.setDate(5, java.sql.Date.valueOf(c.getCreateDate()));
                pstmt.setString(6, c.getCreatedBy());
                //pstmt.setTimestamp(7, c.getLastUpdate());
                pstmt.setString(7, c.getLastUpdateBy());
                pstmt.executeUpdate();

                pstmt2.setString(1, c.getAddress().getAddress());
                pstmt2.setString(2, c.getAddress().getAddress2());
                pstmt2.setInt(3, c.getAddress().getCityId());
                pstmt2.setString(4, c.getAddress().getPostalCode());
                pstmt2.setString(5, c.getAddress().getPhone());
                pstmt2.setDate(6, java.sql.Date.valueOf(c.getCreateDate()));
                pstmt2.setString(7, c.getCreatedBy());
                pstmt2.setString(8, c.getLastUpdateBy());
                pstmt2.executeUpdate();
            }
        }
    }
}
