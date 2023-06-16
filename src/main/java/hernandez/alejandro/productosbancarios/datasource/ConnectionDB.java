package hernandez.alejandro.productosbancarios.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionDB {
	
	static Connection connect() {
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/productosbancarios";
		String user = "usuario";
		String pass = "usuario";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(url, user, pass);
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return connection;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return connection;
			
		}
	}
	
}
