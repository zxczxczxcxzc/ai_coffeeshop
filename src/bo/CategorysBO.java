package bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Categorys;
import dao.CategorysDAO;

public class CategorysBO {
	CategorysDAO dao = new CategorysDAO();
	
	public List<Categorys> getListCategory() {
		List<Categorys> list = new ArrayList<>();
		try {
			list = dao.getListCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean insertCategory(String name, String description, String created_at) {
		try {
			if (dao.insertCategory(name, description, created_at)) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCategory(String id, String name, String description, String created_at) {
		try {
			if (dao.updateCategory(id, name, description, created_at)) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteCategory(String id) {
		try {
			if (dao.deleteCategory(id)) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
