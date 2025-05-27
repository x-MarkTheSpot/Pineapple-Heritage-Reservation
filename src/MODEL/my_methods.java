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
}
