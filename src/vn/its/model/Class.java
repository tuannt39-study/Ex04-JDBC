package vn.its.model;

public class Class {
	private String id;
	private String hoTen;
	private String email;
	private String sdt;
	private String lop;
	private String ghiChu;
	private String account;
	public Class() {
		super();
	}
	public Class(String id, String hoTen, String email, String sdt, String lop, String ghiChu, String account) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.email = email;
		this.sdt = sdt;
		this.lop = lop;
		this.ghiChu = ghiChu;
		this.account = account;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
}
