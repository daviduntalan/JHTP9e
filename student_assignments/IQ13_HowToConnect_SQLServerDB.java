package student_assignments;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
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
 * 4. fetch the required daa using the ResultSet
 * 5. close DB resources
 * 6. run the application
 * 
 * Change password in SQL Server:
 * - https://www.youtube.com/watch?v=TDonCJIQv7w
 * 
 * YT Channel: https://www.youtube.com/channel/UCM5ldu3IonPjffpYSnSYYJA/videos?view=0&sort=da&flow=grid
 * @author David
 */
public class IQ13_HowToConnect_SQLServerDB {

    public static void main(String[] args) {
        
        String server = "David-PC/SQLEXPRESS"; // or localhost\SQLEXPRESS
        String port = "64990"; // from SqlServer Config Mgr./NetProtocol for SQLExpress/IP Addresses/TCP Dynamic Ports
        String user = "sa";
        String password = "admin1234";
        String database = "StudentDB"; // table: Grades (ID, Name, Subject, Grade)
        
        String jdbcUrl = "jdbc:sqlserver://" + server + ":" + port 
                + ";user="  + user + ";password=" + password 
                + ";databaseName=" + database + "";
        
        Connection conn = null;
        Statement st = null; 
        ResultSet rs = null; 
        
        Grades grades = new Grades();
        
        try {
            conn = DriverManager.getConnection(jdbcUrl, user, password);
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM [StudentDB].[dbo].[Grades]");
            
            while (rs.next()) {
                grades.setId(rs.getString(1));
                grades.setName(rs.getString(2));
                grades.setSubject(rs.getString(3));
                grades.setGrade(rs.getString(4));
                System.out.println(grades);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IQ13_HowToConnect_SQLServerDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(IQ13_HowToConnect_SQLServerDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } // end finally
    } // end main
}

@lombok.Setter
@lombok.Getter
@lombok.ToString
class Grades {
    String id;
    String name;
    String subject;
    String grade;
}