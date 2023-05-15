import java.text.DecimalFormat;

public class FarmMachine {
	private int price;
	private int year;
	private String color;
	private String status;

	public FarmMachine(int price, int year, String color) {
		this.price = price;
		this.year = year;
		this.color = color;
	}

	public void printInfo() {
		DecimalFormat form = new DecimalFormat("###,###");
		String parsePrice = form.format(this.price);
		System.out.println(parsePrice);
		System.out.println(this.year);
		System.out.println(this.color);
	}

	public void printStatus() {
		System.out.println("Farm-Machine is " + status);
	}

	public void setStatus(String status) {
		this.status = status;
	}
}