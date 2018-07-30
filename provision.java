import java.sql.*;
import javax.sql.*;
import javax.swing.JOptionPane;
public class provision {
    Connection conn;
    public static Connection provision1()
    {
        String sql = "com.mysql.jdbc.Driver";
        try
        {
            Class.forName(sql);
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/provision","root","");
            return conn;
        }
        catch(Exception ex)
        {
            
             JOptionPane.showMessageDialog(null,ex);
             return null;
        }
    }
    
}
