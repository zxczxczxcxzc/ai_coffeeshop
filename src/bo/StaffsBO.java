package bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Staffs;
import dao.StaffsDAO;

public class StaffsBO {

	StaffsDAO dao = new StaffsDAO();

	public List<Staffs> getListStaffs() {
		List<Staffs> list = new ArrayList<>();
		try {
			list = dao.getListStaff();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean insertStaff(String fullname, String email, String gender, String dateOfBirth, String phone) {
		try {
			if (dao.insertStaff(fullname, email, gender, dateOfBirth, phone)) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateStaff(String id, String fullname, String email, String gender, String dateOfBirth,
			String phone) {
		try {
			if (dao.updateStaff(id, fullname, email, gender, dateOfBirth, phone)) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteStaff(String id) {
		try {
			if (dao.deleteStaff(id)) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		StaffsBO bo = new StaffsBO();
		int id = 17;
		System.out.println(bo.deleteStaff(Integer.toString(id)));
	}
}
