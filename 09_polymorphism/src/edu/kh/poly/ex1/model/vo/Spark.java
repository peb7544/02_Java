package edu.kh.poly.ex1.model.vo;

public class Spark extends Car { // 경차
	
	private double discountOffer; // 할인혜택
	
	public Spark() {} // 기본 생성자

	// 매개변수 생성자
	public Spark(String engine, String fuel, int wheel, double discountOffer) {
		super(engine, fuel, wheel);
		this.discountOffer = discountOffer;
	}

	// getter / setter
	public double getDiscountOffer() {
		return discountOffer;
	}

	public void setDiscountOffer(double discountOffer) {
		this.discountOffer = discountOffer;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " / " + discountOffer ;
	}
}
