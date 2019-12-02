package pojos;

import java.time.Month;

public class Bill {

	private static int billCounter;
	private int billNo;
	private double billAmount;
	private Month month;

	public Bill() {
		super();
		billNo = ++billCounter;
	}

	public Bill(double billAmount, Month month) {
		super();
		this.billAmount = billAmount;
		this.month = month;
	}

	public Bill(int billNo, double billAmount, Month month) {
		super();
		this.billNo = billNo;
		this.billAmount = billAmount;
		this.month = month;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

}
