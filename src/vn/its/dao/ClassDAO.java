package vn.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.its.connect.DBConnect;
import vn.its.model.Class;
import vn.its.util.JDBCUtil;

public class ClassDAO {

	// Danh sách tất cả các học viên
	public ArrayList<Class> getListClass() throws SQLException {
		Connection conn = DBConnect.getDBConnection();
		String selectClass = "SELECT ID, HOTEN, EMAIL, SDT, LOP, GHICHU, ACCOUNT FROM ITSOL.CLASS";
		PreparedStatement pstmt = conn.prepareStatement(selectClass);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Class> list = new ArrayList<Class>();
		while (rs.next()) {
			String id = rs.getString("id");
			String hoTen = rs.getString("hoTen");
			String email = rs.getString("email");
			String sdt = rs.getString("sdt");
			String lop = rs.getString("lop");
			String ghiChu = rs.getString("ghiChu");
			String account = rs.getString("account");
			Class cla = new Class();
			cla.setId(id);
			cla.setHoTen(hoTen);
			cla.setEmail(email);
			cla.setSdt(sdt);
			cla.setLop(lop);
			cla.setGhiChu(ghiChu);
			cla.setAccount(account);
			list.add(cla);
		}
		return list;
	}

	// Danh sách các học viên theo lớp
	public ArrayList<Class> getFilterClass(String clas) throws SQLException {
		Connection conn = DBConnect.getDBConnection();
		String selectFilterClass = "SELECT ID, HOTEN, EMAIL, SDT, LOP, GHICHU, ACCOUNT FROM ITSOL.CLASS " + "WHERE LOP = '" + clas +"'";
		PreparedStatement pstmt = conn.prepareStatement(selectFilterClass);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Class> list = new ArrayList<Class>();
		while (rs.next()) {
			String id = rs.getString("id");
			String hoTen = rs.getString("hoTen");
			String email = rs.getString("email");
			String sdt = rs.getString("sdt");
			String lop = rs.getString("lop");
			String ghiChu = rs.getString("ghiChu");
			String account = rs.getString("account");
			Class cla = new Class();
			cla.setId(id);
			cla.setHoTen(hoTen);
			cla.setEmail(email);
			cla.setSdt(sdt);
			cla.setLop(lop);
			cla.setGhiChu(ghiChu);
			cla.setAccount(account);
			list.add(cla);
		}
		return list;
	}

	// Tìm kiếm học viên theo tên
	public ArrayList<Class> getFilterHoTen(String clas) throws SQLException {
		Connection conn = DBConnect.getDBConnection();
		String selectFilterHoTen = "SELECT ID, HOTEN, EMAIL, SDT, LOP, GHICHU, ACCOUNT FROM ITSOL.CLASS " + "WHERE HOTEN LIKE '%" + clas +"%'";
		PreparedStatement pstmt = conn.prepareStatement(selectFilterHoTen);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Class> list = new ArrayList<Class>();
		while (rs.next()) {
			String id = rs.getString("id");
			String hoTen = rs.getString("hoTen");
			String email = rs.getString("email");
			String sdt = rs.getString("sdt");
			String lop = rs.getString("lop");
			String ghiChu = rs.getString("ghiChu");
			String account = rs.getString("account");
			Class cla = new Class();
			cla.setId(id);
			cla.setHoTen(hoTen);
			cla.setEmail(email);
			cla.setSdt(sdt);
			cla.setLop(lop);
			cla.setGhiChu(ghiChu);
			cla.setAccount(account);
			list.add(cla);
		}
		return list;
	}
	
	// Thêm bản ghi
	public void insertClass(Class cla) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String insertClass = "INSERT INTO ITSOL.CLASS (ID, HOTEN, EMAIL, SDT, LOP, GHICHU, ACCOUNT) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			conn = DBConnect.getDBConnection();
			pstmt = conn.prepareStatement(insertClass);
			pstmt.setString(1, cla.getId());
			pstmt.setString(2, cla.getHoTen());
			pstmt.setString(3, cla.getEmail());
			pstmt.setString(4, cla.getSdt());
			pstmt.setString(5, cla.getLop());
			pstmt.setString(6, cla.getGhiChu());
			pstmt.setString(7, cla.getAccount());
			pstmt.executeUpdate();
			System.out.println("Thêm thành công!");
		} catch (SQLException e) {
			JDBCUtil.printSQLException(e);
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

	// Cập nhật bản ghi
	public void updateClass(Class cla) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String updateClass = "UPDATE ITSOL.CLASS "
					+ "SET HOTEN = ?, EMAIL = ?, SDT = ?, LOP = ?, GHICHU = ?, ACCOUNT = ? WHERE ID = ?";
			conn = DBConnect.getDBConnection();
			pstmt = conn.prepareStatement(updateClass);
			pstmt.setString(1, cla.getHoTen());
			pstmt.setString(2, cla.getEmail());
			pstmt.setString(3, cla.getSdt());
			pstmt.setString(4, cla.getLop());
			pstmt.setString(5, cla.getGhiChu());
			pstmt.setString(6, cla.getAccount());
			pstmt.setString(7, cla.getId());
			pstmt.executeUpdate();
			System.out.println("Cập nhật thành công!");
		} catch (SQLException e) {
			JDBCUtil.printSQLException(e);
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}
	
	// Xóa bản ghi
	public void deleteClass(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String deleteClass = "DELETE FROM ITSOL.CLASS "
					+ "WHERE ID = ?";
			conn = DBConnect.getDBConnection();
			pstmt = conn.prepareStatement(deleteClass);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			System.out.println("Xóa thành công ID = " + id);
		} catch (SQLException e) {
			JDBCUtil.printSQLException(e);
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

//	public static void main(String[] args) throws SQLException {
//		ClassDAO cla = new ClassDAO();
//		
//		cla.insertClass(new Class("SV06", "Nguyễn Sáu", "sau@gmail.com", "09999999996", "LH1", "Không", "tuan"));
//		
//		cla.updateClass(new Class("SV05", "Nguyễn Năm", "nam@gmail.com", "09999999995", "LH2", "Không", "tuan"));
//		
//		System.out.println("ID\t" + "HOTEN\t\t" + "EMAIL\t\t" + "SDT\t\t" + "LOP\t" + "GHICHU\t" + "ACCOUNT");
//		for (Class cl : cla.getListClass()) {
//			System.out.println(cl.getId() + "\t" + cl.getHoTen() + "\t" + cl.getEmail() + "\t" + cl.getSdt() + "\t"
//					+ cl.getLop() + "\t" + cl.getGhiChu() + "\t" + cl.getAccount());
//		}
//		
//		cla.deleteClass("SV03");
//		
//		System.out.println("ID\t" + "HOTEN\t\t" + "EMAIL\t\t" + "SDT\t\t" + "LOP\t" + "GHICHU\t" + "ACCOUNT");
//		for (Class cl : cla.getFilterClass("LH2")) {
//		System.out.println(cl.getId() + "\t" + cl.getHoTen() + "\t" + cl.getEmail() + "\t" + cl.getSdt() + "\t"
//				+ cl.getLop() + "\t" + cl.getGhiChu() + "\t" + cl.getAccount());
//		}
//		
//		System.out.println("ID\t" + "HOTEN\t\t" + "EMAIL\t\t" + "SDT\t\t" + "LOP\t" + "GHICHU\t" + "ACCOUNT");
//		for (Class cl : cla.getFilterHoTen("ộ")) {
//		System.out.println(cl.getId() + "\t" + cl.getHoTen() + "\t" + cl.getEmail() + "\t" + cl.getSdt() + "\t"
//				+ cl.getLop() + "\t" + cl.getGhiChu() + "\t" + cl.getAccount());
//		}
//		
//	}
	
	
}
