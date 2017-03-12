package by.hryshchanka.task2.entity;

import java.math.BigDecimal;

public class Pearl extends Gem {
	private double diameter;
	
	public Pearl(GemName name, double weight, BigDecimal cost, Transparency transparency, double diameter) {
		super(name, weight, cost, transparency);
		this.diameter = diameter;
	}
	
	public Pearl() {
		super();
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", diameter = " + diameter + "mm";
	}
}
