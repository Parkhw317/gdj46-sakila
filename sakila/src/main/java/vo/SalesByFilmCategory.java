package vo;

public class SalesByFilmCategory {
	
	private String category;
	private double totalSales;
	
	
	@Override
	public String toString() {
		return "SalesByFilmCategory [catregory=" + category + ", totalSales=" + totalSales + "]";
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String catregory) {
		this.category = catregory;
	}
	public double getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(double totalSales) {
		this.totalSales = totalSales;
	}

	
}
