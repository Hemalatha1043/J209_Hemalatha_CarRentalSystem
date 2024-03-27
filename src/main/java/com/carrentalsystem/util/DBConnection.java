package com.carrentalsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for managing database connections.
 */
public class DBConnection {
    static Connection con;

    /**
     * Retrieves a database connection.
     * 
     * @return Connection object representing the database connection.
     */
    public static Connection getDBConn() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/J209_CarRentalSystem", "root",
                    "Hemalatha_1043");
        } catch (SQLException e) {
            // Print the stack trace in case of an exception
            e.printStackTrace();
        }

        return con;
    }

    /**
     * Closes the database connection.
     */
    public static void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            // Print the stack trace in case of an exception
            e.printStackTrace();
        }
    }
}
