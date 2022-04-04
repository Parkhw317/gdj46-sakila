package vo;

public class StaffList {
	
	private int staffId;
	private String staffName;
	private String address;
	private String zipCode;
	private String phone;
	private String city;
	private String country;
	private int sid;
	
	
	
	@Override
	public String toString() {
		return "StaffList [staffId=" + staffId + ", staffName=" + staffName + ", address=" + address + ", zipCode="
				+ zipCode + ", phone=" + phone + ", city=" + city + ", country=" + country + ", sid=" + sid + "]";
	}
	
	
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	
	

}
