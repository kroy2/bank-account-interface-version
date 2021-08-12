package Database;

import java.util.*;

public class Bill {
	String Billname = "";
	double cost = 0;
	double frequency = 0;

	public Bill(String name, double price, double recurrence) {
		this.Billname = name;
		this.cost = price;
		this.frequency = recurrence;
	}

	public void setBillName(String name) {
		this.Billname = name;
	}

	public String getBillName() {
		return this.Billname;
	}

	public void setCost(double amount) {
		this.cost = amount;
	}

	public double getCost() {
		return this.cost;
	}

	public void setFrequency(double amount) {
		this.frequency = amount;
	}

}
