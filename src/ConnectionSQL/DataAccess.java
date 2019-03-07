package ConnectionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataAccess {
	private String url = "jdbc:sqlserver://localhost:1433;databaseName=AI_CoffeeShop";//mở sql lên thay cái tên trong db lại
	private String userName = "sa";// thay user với pass lại là xong o koK? ok ? ok chưa
	private String password = "sa123";
	private static Connection connection = null;
	private static PreparedStatement pst = null;
	private static DataAccess instance;

	private DataAccess() {}
	
	public static DataAccess getInstance() {
		if (instance == null) {
			synchronized (DataAccess.class) {
				if (instance == null) {
					instance = new DataAccess();
				}
			}
		}
		return instance;
	}

	public Connection createConnection() {
		if (connection == null) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection(url, userName, password);
				System.out.println("ok");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	public void shutdown() {
		try {
			if (pst != null) {
				pst.close();
			}
			if (connection != null) {
				DriverManager.getConnection(url + ";shutdown=true");
				connection.close();
			}
		} catch (SQLException sqlExcept) {
		}
	}

	public static void main(String[] args) {
		DataAccess con = new DataAccess();
		con.createConnection();
	}
}
