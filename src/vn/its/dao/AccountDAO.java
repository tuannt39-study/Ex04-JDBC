package vn.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vn.its.connect.DBConnect;
import vn.its.model.Account;
import vn.its.util.JDBCUtil;

public class AccountDAO {

	// Kiểm tra tài khoản
	public boolean checkAccount(String acc) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String checkAccount = "SELECT ACCOUNT " + "FROM ITSOL.ACCOUNT " + "WHERE ACCOUNT = '" + acc +"'";
			conn = DBConnect.getDBConnection();
			pstmt = conn.prepareStatement(checkAccount);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				conn.close();
				return true;
			}
		} catch (SQLException e) {
			JDBCUtil.printSQLException(e);
		} return false;
	}

	// Thêm bản ghi
	public void insertAccount(Account acc) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String insertAccount = "INSERT INTO ITSOL.ACCOUNT (ACCOUNT, EMAIL, FIRSTNAME, LASTNAME) "
					+ "VALUES (?, ?, ?, ?)";
			conn = DBConnect.getDBConnection();
			pstmt = conn.prepareStatement(insertAccount);
			pstmt.setString(1, acc.getAccount());
			pstmt.setString(2, acc.getEmail());
			pstmt.setString(3, acc.getFirstName());
			pstmt.setString(4, acc.getLastName());
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
	public void updateAccount(Account acc) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String updateAccount = "UPDATE ITSOL.ACCOUNT "
					+ "SET EMAIL = ?, FIRSTNAME = ?, LASTNAME = ?  WHERE ACCOUNT = ?";
			conn = DBConnect.getDBConnection();
			pstmt = conn.prepareStatement(updateAccount);
			pstmt.setString(1, acc.getEmail());
			pstmt.setString(2, acc.getFirstName());
			pstmt.setString(3, acc.getLastName());
			pstmt.setString(4, acc.getAccount());
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

//	public static void main(String[] args) throws SQLException {
//		AccountDAO acc = new AccountDAO();
//		if (acc.checkAccount("tuan1")==true) {
//			System.out.println("Tài khoản đã tồn tại");
//		} else {
//			System.out.println("Bạn có thể tạo tài khoản");
//		}
//		acc.insertAccount(new Account("thai", "thai@gmail.com", "Trần", "Thái"));
//		acc.updateAccount(new Account("tuan", "tuan@gmail.com", "Nguyễn", "Tuân"));
//	}
}
