package by.hryshchanka.task2.entity;

import java.math.BigDecimal;

public class Amber extends Gem {
	private AmberInclusion inclusion;

	public Amber(GemName name, double weight, BigDecimal cost, Transparency transparency, AmberInclusion inclusion) {
		super(name, weight, cost, transparency);
		this.inclusion = inclusion;
	}

	public Amber() {
		super();
	}

	public AmberInclusion getInclusion() {
		return inclusion;
	}

	public void setInclusion(AmberInclusion inclusion) {
		this.inclusion = inclusion;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", " + inclusion + " inclusion";
	}
}
