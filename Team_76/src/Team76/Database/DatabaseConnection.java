package Team76.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {

	public Connection establishConnection() throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
		Connection connection = null;	
		String connectionUrl = "jdbc:mysql://localhost:3306/";
		String database = "ser516p2";
		String userid = "root";
		String password = "199021";
		connection = DriverManager.getConnection(connectionUrl+database, userid, password);
		return connection;
	}
}
