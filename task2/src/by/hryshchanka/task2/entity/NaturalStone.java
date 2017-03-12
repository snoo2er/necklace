package by.hryshchanka.task2.entity;

import java.math.BigDecimal;

public class NaturalStone extends Gem{
	private Clarity clarity;

	public NaturalStone(GemName name, double weight, BigDecimal cost, Transparency transparency, Clarity clarity) {
		super(name, weight, cost, transparency);
		this.clarity = clarity;
	}

	public NaturalStone() {
		super();
	}

	public NaturalStone(Clarity clarity) {
		super();
		this.clarity = clarity;
	}

	public Clarity getClarity() {
		return clarity;
	}

	public void setClarity(Clarity clarity) {
		this.clarity = clarity;
	}

	@Override
	public String toString() {
		return "Natural " + super.toString() + ", clarity = " + clarity;
	}
}
