package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by h-pc on 16-Oct-15.
 */
public class ConnectionClass {
    String ip = "198.37.116.39";
    String db = "fridayice";
    String un = "aaelkawy_SQLLogin_1";
    String password = "aaelkawy";

    @SuppressLint("NewApi")
    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            ConnURL = "jdbc:sqlserver://" + ip + ";"
                    + "databaseName=" + db + ";user=" + un + ";password="
                    + password + ";";
            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            Log.e("ERRO_sq", se.getMessage());

        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return conn;
    }
}