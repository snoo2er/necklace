package by.hryshchanka.task2.entity;

import java.math.BigDecimal;

public class SyntheticStone extends Gem {
	private Clarity clarity;


	public SyntheticStone(GemName name, double weight, BigDecimal cost, Transparency transparency, Clarity clarity) {
		super(name, weight, cost, transparency);
		this.clarity = clarity;
	}

	public SyntheticStone() {
		super();
	}
	
	public Clarity getClarity() {
		return clarity;
	}

	public void setClarity(Clarity clarity) {
		this.clarity = clarity;
	}
	
	@Override
	public String toString() {
		return "Synthetic " + super.toString() + ", clarity = " + clarity;
	}
}
