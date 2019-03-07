package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ConnectionSQL.DataAccess;
import bean.Categorys;

public class CategorysDAO {
	DataAccess instanceSQL = DataAccess.getInstance();

	public List<Categorys> getListCategory() throws SQLException {
		ArrayList<Categorys> list = new ArrayList<>();
		Connection con = instanceSQL.createConnection();
		ResultSet result = null;
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			String query = "select * from product_category";
			result = stmt.executeQuery(query);
			Categorys categorys = null;
			while(result.next()) {
				categorys = new Categorys();
				categorys.setId(result.getString("id"));
				categorys.setName(result.getString("name"));
				categorys.setDescription(result.getString("description"));
				categorys.setCreated_at(result.getString("created_at"));
				list.add(categorys);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (result != null) {
				result.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		
		return list;
	}
	
	public boolean insertCategory(String name, String description, String created_at) throws SQLException {
		Connection con = instanceSQL.createConnection();
		PreparedStatement preStmt = null;
		String query = "INSERT INTO product_category(name, description, created_at) VALUES(?,?,?)";
		try {
			preStmt = con.prepareStatement(query);
			preStmt.setString(1, name);
			preStmt.setString(2, description);
			preStmt.setString(3, created_at);

			if (preStmt.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (preStmt != null) {
				preStmt.close();
			}
		}
	}
	
	public boolean updateCategory(String id, String name, String description, String created_at) throws SQLException {
		Connection con = instanceSQL.createConnection();
		PreparedStatement preStmt = null;

		String query = "UPDATE product_category SET name = ?, description = ?, created_at = ? WHERE id = ?";
		try {
			preStmt = con.prepareStatement(query);
			preStmt.setString(1, name);
			preStmt.setString(2, description);
			preStmt.setString(3, created_at);
			preStmt.setString(4, id);
			if (preStmt.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (preStmt != null) {
				preStmt.close();
			}
		}
	}
	
	public boolean deleteCategory(String id) throws SQLException {
		Connection con = null;
		PreparedStatement preStm = null;
		con = instanceSQL.createConnection();

		String query = "DELETE FROM product_category WHERE id = ?";

		try {
			preStm = con.prepareStatement(query);
			preStm.setString(1, id);
			if (preStm.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (preStm != null) {
				preStm.close();
			}
		}
	}

}
