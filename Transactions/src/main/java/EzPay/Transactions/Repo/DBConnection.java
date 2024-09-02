package EzPay.Transactions.Repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 

public class DBConnection {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {    
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "hr";
        String password = "password";
        Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url, username, password);
    }

}