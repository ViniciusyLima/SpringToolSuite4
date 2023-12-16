package agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() throws ClassNotFoundException  {
		try {
			return DriverManager.getConnection(
				"jdbc:mysql://localhost/cadastro","root","root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}