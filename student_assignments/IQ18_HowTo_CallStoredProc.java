package student_assignments;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.CallableStatement;

/**
 * Guide to this Code are coming from: https://youtu.be/NJAGYU6tQ9w
 * YT Channel: https://www.youtube.com/channel/UCM5ldu3IonPjffpYSnSYYJA/videos?view=0&sort=da&flow=grid
 * @author David
 */
public class IQ18_HowTo_CallStoredProc {

    public static void main(String[] args) {
               
        // Make sure that your TCP/IP were Enabled from SQlServer Config Mgr.
        String server = "127.0.0.1"; // localhost or David-PC
        String port = "64990"; // from SqlServer Config Mgr./NetProtocol for SQLExpress/IP Addresses/TCP Dynamic Ports
        String user = "sa"; // provide your own username and
        String password = "admin1234"; // password here, thank you.
        String database = "MyCompany"; // table: Employee (employee_id, 
        // first_name, last_name, gender, position, department_id, salary)
        
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null; 
        
        SQLServerDataSource ds = new SQLServerDataSource();  
        ds.setUser(user);  
        ds.setPassword(password);  
        ds.setServerName(server);  
        ds.setPortNumber(Integer.parseInt(port));
        ds.setDatabaseName(database);  
        
        try {            
            conn = ds.getConnection();                        
            cs = conn.prepareCall("{call Employee_getById(?)}");
            cs.setInt("@EmpId", 2009); // you can use index column instead
            rs = cs.executeQuery();

            System.out.printf("%-6s %-10s %-10s %-6s %-20s %-10s %9s\n", 
                    "Emp ID", "First", "Last", "Gender", 
                    "Position", "Department", "Salary");
            while (rs.next()) {                
                System.out.printf("%6d %-10s %-10s %-6s %-20s %-10s %9.2f\n", 
                    rs.getInt(1), rs.getString(2), rs.getString(3), 
                    rs.getString(4), rs.getString(5), rs.getString(6), 
                    rs.getDouble(7)
                );            
            }
        } catch (SQLException ex) {
            Logger.getLogger(IQ18_HowTo_CallStoredProc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {                
                rs.close();                
                cs.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(IQ18_HowTo_CallStoredProc.class.getName()).log(Level.SEVERE, null, ex);
            }
        } // end finally
    } // end main
}