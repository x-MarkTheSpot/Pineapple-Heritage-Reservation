package MODEL;

/**
 *
 * @author User
 */

import java.sql.*;
import CONTROLLER.cust_methods;
import static MODEL.db_connect.myConnection;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
public class my_methods extends db_connect{
    Connection con = myConnection();
    PreparedStatement smt = null;
    ResultSet rs = null;
    
    cust_methods obj = new cust_methods();
    
    
    // for Insert, Update, Delete
    public void Chony(String query){
        try{
            smt = con.prepareStatement(query);
            smt.execute(query);
            smt.close();
            obj.Prompt("Success!");
        }catch(Exception e){
            obj.Prompt(""+e);
        }
    }
    
    // for display rows to table
    public void DisplayTable(JTable tbl,String sql){
        try{
            smt = con.prepareStatement(sql);
            rs = smt.executeQuery(sql);
            tbl.setModel(DbUtils.resultSetToTableModel(rs));        
            smt.close();
            rs.close();
        }catch(Exception e){
            obj.Prompt(""+e);
        }
    }
    
    //for login interface
    public String databal(String query, String col){
        String result = new String();
        try{
            smt = con.prepareStatement(query);
            rs = smt.executeQuery(query);
            if (rs.next())
                result = rs.getString(col);
            smt.close();
            rs.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }
    
    public int getTotalAdmins() {
    String query = "SELECT COUNT(*) AS total FROM tbl_admin";
    String result = databal(query, "total");
    try {
        return Integer.parseInt(result);
    } catch (NumberFormatException e) {
        return 0;
    }
}

    public int getTotalCustomers() {
    String query = "SELECT COUNT(*) AS total FROM tbl_customers";
    String result = databal(query, "total");
    try {
        return Integer.parseInt(result);
    } catch (NumberFormatException e) {
        return 0;
    }
}

    public int getTotalHotels() {
    String query = "SELECT COUNT(*) AS total FROM tbl_hotel";
    String result = databal(query, "total");
    try {
        return Integer.parseInt(result);
    } catch (NumberFormatException e) {
        return 0;
    }
}

    public int getTotalPayments() {
    String query = "SELECT COUNT(*) AS total FROM tbl_payment";
    String result = databal(query, "total");
    try {
        return Integer.parseInt(result);
    } catch (NumberFormatException e) {
        return 0;
    }
}

    public int getTotalReservations() {
    String query = "SELECT COUNT(*) AS total FROM tbl_reservations";
    String result = databal(query, "total");
    try {
        return Integer.parseInt(result);
    } catch (NumberFormatException e) {
        return 0;
    }
}

    public int getTotalRooms() {
    String query = "SELECT COUNT(*) AS total FROM tbl_rooms";
    String result = databal(query, "total");
    try {
        return Integer.parseInt(result);
    } catch (NumberFormatException e) {
        return 0;
    }
}

    public int getTotalStaff() {
    String query = "SELECT COUNT(*) AS total FROM tbl_staff";
    String result = databal(query, "total");
    try {
        return Integer.parseInt(result);
    } catch (NumberFormatException e) {
        return 0;
    }
}

}
