package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Created by CHANNATH on 29-Nov-2014.
 */
public class ConnectionMySQL {
    public Connection dataConn = null;
    public String sourceURL = null;

    public ConnectionMySQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            sourceURL = "jdbc:mysql://localhost/posrestaurent";
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Could not initialize driver.");
            return;
        }
    }

    public Connection connect() {
        try {
            dataConn = DriverManager.getConnection(sourceURL, "root", "");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Could not connect to data source mysql.");
        }
        return dataConn;
    }

    public void close(Connection conn) {
        if (conn != null) {
            try {
                dataConn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Could not close connection.");
                return;
            }
        }
    }
}
