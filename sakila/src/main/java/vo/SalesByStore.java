package vo;

public class SalesByStore {
	
	private String store;
	private String manager;
	private double totalSales;

	
	@Override
	public String toString() {
		return "SaleByStore [store=" + store + ", manager=" + manager + ", totlaSales=" + totalSales + "]";
	}
	
	
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public double getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(double totalSales) {
		this.totalSales = totalSales;
	}
	
	

}
