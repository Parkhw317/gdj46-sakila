package vo;

public class CustomerList {
	
	private int customerId;
	private String customerName;
	private String customerAddr;
	private String zipCode;
	private String phone;
	private String city;
	private String country;
	private String notes;
	private int sid;
	
	@Override
	public String toString() {
		return "CustomerList [customerName=" + customerName + ", customerAddr=" + customerAddr + ", zipCode=" + zipCode
				+ ", phone=" + phone + ", city=" + city + ", country=" + country + ", notes=" + notes + ", sid=" + sid
				+ ", customerId=" + customerId + "]";
	}
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddr() {
		return customerAddr;
	}
	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
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
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}

	

}
