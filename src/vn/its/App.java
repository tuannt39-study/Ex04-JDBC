package vn.its;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import vn.its.connect.DBConnect;
import vn.its.dao.AccountDAO;
import vn.its.dao.ClassDAO;
import vn.its.model.Account;

@SuppressWarnings("resource")
public class App {
	
	public static void main(String[] args) throws SQLException, IOException {
		DBConnect.getDBConnection();
		System.out.println("Đăng ký tài khoản với hệ thống!\n---------");
		Scanner sc = new Scanner(System.in);
		System.out.print("Tên tài khoản: ");
		String acc = sc.nextLine();
		System.out.print("Email: ");
		String eml = sc.nextLine();
		System.out.print("Họ: ");
		String first = sc.nextLine();
		System.out.print("Tên: ");
		String last = sc.nextLine();
		
		AccountDAO account = new AccountDAO();
		if (account.checkAccount(acc)==true) {
			System.out.println("Tài khoản đã tồn tại!\nHệ thống sẽ tự động lưu lại các thông tin đã thay đổi!");
			account.updateAccount(new Account(acc, eml, first, last));
			managerClass();
		} else {
			System.out.println("Đăng ký tài khoản thành công!");
			account.insertAccount(new Account(acc, eml, first, last));
			managerClass();
		}
	}
	
	public static void printClass() throws SQLException {
		ClassDAO cla = new ClassDAO();
		System.out.println("ID\t" + "HOTEN\t\t" + "EMAIL\t\t" + "SDT\t\t" + "LOP\t" + "GHICHU\t" + "ACCOUNT");
		for (vn.its.model.Class cl : cla.getListClass()) {
			System.out.println(cl.getId() + "\t" + cl.getHoTen() + "\t" + cl.getEmail() + "\t" + cl.getSdt() + "\t"
					+ cl.getLop() + "\t" + cl.getGhiChu() + "\t" + cl.getAccount());
		}
	}
	
	public static void managerClass() throws IOException, SQLException {
		System.out.println("1. Xem danh sách tất cả các học viên");
        System.out.println("2. Xem danh sách học sinh theo lớp");
        System.out.println("3. Tìm kiếm tên 1 học viên");
        System.out.println("4. Thêm 1 học viên vào hệ thống");
        System.out.println("5. Sửa 1 học viên trong hệ thống");
        System.out.println("6. Xóa 1 học viên trong hệ thống");
        do {
        	System.out.println("Chọn chức năng muốn thực hiện: ");
        	Scanner sc = new Scanner(System.in);
        	int input = sc.nextInt();
        	sc.nextLine();
        	ClassDAO cla = new ClassDAO();
        	switch (input) {
			case 1:
				System.out.println("ID\t" + "HOTEN\t\t" + "EMAIL\t\t" + "SDT\t\t" + "LOP\t" + "GHICHU\t" + "ACCOUNT");
				for (vn.its.model.Class cl : cla.getListClass()) {
					System.out.println(cl.getId() + "\t" + cl.getHoTen() + "\t" + cl.getEmail() + "\t" + cl.getSdt() + "\t"
							+ cl.getLop() + "\t" + cl.getGhiChu() + "\t" + cl.getAccount());
				}
				break;
			case 2:
				System.out.print("Danh sách học viên lớp: ");
				String nameClass = sc.nextLine();
				System.out.println("ID\t" + "HOTEN\t\t" + "EMAIL\t\t" + "SDT\t\t" + "LOP\t" + "GHICHU\t" + "ACCOUNT");
				for (vn.its.model.Class cl : cla.getFilterClass(nameClass)) {
					System.out.println(cl.getId() + "\t" + cl.getHoTen() + "\t" + cl.getEmail() + "\t" + cl.getSdt() + "\t"
							+ cl.getLop() + "\t" + cl.getGhiChu() + "\t" + cl.getAccount());
				}
				break;
			case 3:
				System.out.print("Tìm kiếm theo tên của học viên: ");
				String hotenHV = sc.nextLine();
				System.out.println("ID\t" + "HOTEN\t\t" + "EMAIL\t\t" + "SDT\t\t" + "LOP\t" + "GHICHU\t" + "ACCOUNT");
				for (vn.its.model.Class cl : cla.getFilterHoTen(hotenHV)) {
					System.out.println(cl.getId() + "\t" + cl.getHoTen() + "\t" + cl.getEmail() + "\t" + cl.getSdt() + "\t"
							+ cl.getLop() + "\t" + cl.getGhiChu() + "\t" + cl.getAccount());
				}
				break;
			case 4:
				System.out.print("Nhập thông tin học viên muốn thêm: ");
				System.out.print("\nID: ");
				String id = sc.nextLine();
				System.out.print("Họ tên: ");
				String hoten = sc.nextLine();
				System.out.print("Email: ");
				String email = sc.nextLine();
				System.out.print("SĐT: ");
				String sdt = sc.nextLine();
				System.out.print("Lớp: ");
				String lop = sc.nextLine();
				System.out.print("Ghi chú: ");
				String ghiChu = sc.nextLine();
				System.out.print("Giáo vụ phụ trách: ");
				String account = sc.nextLine();
				cla.insertClass(new vn.its.model.Class(id, hoten, email, sdt, lop, ghiChu, account));
				System.out.println("Thêm học viên thành công");
				break;
			case 5:
				System.out.print("Nhập thông tin học viên muốn sửa: ");
				System.out.print("\nID: ");
				String id1 = sc.nextLine();
				System.out.print("Họ tên: ");
				String hoten1 = sc.nextLine();
				System.out.print("Email: ");
				String email1 = sc.nextLine();
				System.out.print("SĐT: ");
				String sdt1 = sc.nextLine();
				System.out.print("Lớp: ");
				String lop1 = sc.nextLine();
				System.out.print("Ghi chú: ");
				String ghiChu1 = sc.nextLine();
				System.out.print("Giáo vụ phụ trách: ");
				String account1 = sc.nextLine();
				cla.updateClass(new vn.its.model.Class(id1, hoten1, email1, sdt1, lop1, ghiChu1, account1));
				System.out.println("Sửa thông tin học viên thành công");
				break;
			case 6:
				System.out.print("Nhập ID học viên muốn xóa: ");
				String id2 = sc.nextLine();
				cla.deleteClass(id2);
				System.out.println("Xóa học viên thành công");
				break;
			}
        } while(check());
	}
	
	public static boolean check() throws IOException {
        System.out.print("Nhấn N để dùng hoặc phím bất kỳ khác để tiếp tục: ");
        Scanner sc = new Scanner(System.in);
    	String input = sc.nextLine();
        if (input.equalsIgnoreCase("N")) {
            return false;
        } else {
            return true;
        }
    }
	
}


