package MODEL;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
import java.sql.*;
import javax.swing.*;
public class db_connect {
    public static Connection myConnection(){
        Connection con = null;
        try{
            // API + engine + host
            // jdbc:mysql://localhost:3306/db_pageant
            String URL = "jdbc:mysql://localhost:3306/";
            String db_name = "db_pineapple_heritage_online_hotel_reservation";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(URL+db_name,username,password);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return con;
    }
    
    public static void main(String[] args){
        Connection test = myConnection();
        if(test!=null){
            JOptionPane.showMessageDialog(null,"Success!");
        }
    }
}
