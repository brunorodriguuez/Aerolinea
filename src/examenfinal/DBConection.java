package examenfinal;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBConection {
    final String CONTROLLER = "com.mysql.cj.jdbc.Driver";
    final String URLDB = "jdbc:mysql://localhost:3306/examenfinal?serverTimezone=UTC";
    public Connection con = null;
    public Statement st = null;
    public ResultSet resSet = null;
    public ResultSetMetaData md = null;
    
    public DBConection() throws ClassNotFoundException, SQLException{   
        Class.forName(CONTROLLER);
        con = DriverManager.getConnection(URLDB, "root", "");
        st = con.createStatement();
    }
    
    public Connection conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/examenfinal?serverTimezone=UTC","root","");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return con;
    }
}
