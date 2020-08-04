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
 * 
 * Things you need...
 * 
 * Existing database
 * - SQL Server
 * 
 * Jar file (sqljdbc.jar)
 * - libraries you need to connect to the DB
 * - driver
 * - download here: 
 * https://go.microsoft.com/fwlink/?linkid=852460 mssql-jdbc-6.2.2.jre8.jar 
 * https://go.microsoft.com/fwlink/?linkid=2063159 for JRE 8, 11
 * https://go.microsoft.com/fwlink/?linkid=2099962 for JRE 8, 11, 12
 * https://docs.microsoft.com/en-us/sql/connect/jdbc/microsoft-jdbc-driver-for-sql-server
 * https://www.youtube.com/redirect?v=nly_2b9QeO4&event=video_description&redir_token=QUFFLUhqbnRHV01CdFZ2UVktdlNrYzZHQ0RRUmhFLXFKQXxBQ3Jtc0tuTkEtM0tCM3FoVXFqRVROelJrT0dlUHZYX1VmZVA3MVdobmtlalVrQ0c4UFlVYWs0WFNWVkNkd0Rrb3pTYTFMcXhLUzkwWXlIQTduZ2NYV25OLU5RZHhldU54YW1SMDVKeGVYa3F6cUZhb1JURFpkWQ%3D%3D&q=http%3A%2F%2Fwww.java2s.com%2FCode%2FJar%2Fs%2FDownloadsqljdbc420jar.htm
 * 
 * Steps:
 * 1. connect to DB using JDBC URL
 * 2. create statement object
 * 3. invoke statement.executeQuery on query you're passing to the DB
 * 4. fetch the required data using the ResultSet
 * 5. close DB resources
 * 6. run the application
 * 
 * Change password in SQL Server:
 * - https://www.youtube.com/watch?v=TDonCJIQv7w
 * 
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
        String database = "MyCompany"; // table: Employee (employee_id, first_name, last_name, gender, position, department_id, salary)
        
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
            cs.setInt("@EmpId", 2008); // you can use index column instead
            rs = cs.executeQuery();

            System.out.printf("%-6s %-10s %-10s %6s %-20s %9s\n", 
                    "Emp ID", "First", "Last", "Gender", 
                    "Position", "Salary");            
            while (rs.next()) {                
                System.out.printf("%6d %-10s %-10s %6s %-20s %9.2f\n", 
                    rs.getInt(1), rs.getString(2), rs.getString(3), 
                    rs.getString(4), rs.getString(5), rs.getDouble(7));            
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