package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by CHANNATH on 29-Nov-2014.
 */
public class ConnectionMySQL {
    public static Connection dataConn = null;
    public String host;
    public String database;
    public String username;
    public String password;

    public ConnectionMySQL(String host, String database, String username, String password) throws Exception {
        this.host = host;
        this.database = database;
        this.username = username;
        this.password = password;
        Class.forName("com.mysql.jdbc.Driver");
        dataConn = DriverManager.getConnection("jdbc:mysql://"+host+"/"+database, username, password);
    }

    public String getHost() {
        return host;
    }

    public String getDatabase() {
        return database;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
