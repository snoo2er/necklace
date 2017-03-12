package by.hryshchanka.task2.entity;

import java.math.BigDecimal;

public class Gem {
	private GemName name;
	private long id;
	private double weight;
	private BigDecimal cost;
	private Transparency transparency;
	
	public Gem(GemName name, double weight, BigDecimal cost, Transparency transparency) {
		super();
		this.name = name;
		this.weight = weight;
		this.cost = cost;
		this.transparency = transparency;
	}
	
	public Gem() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public GemName getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public Transparency getTransparency() {
		return transparency;
	}

	public void setName(GemName name) {
		this.name = name;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public void setTransparency(Transparency transparency) {
		this.transparency = transparency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((transparency == null) ? 0 : transparency.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Gem other = (Gem) obj;
		if (cost == null) {
			if (other.cost != null) {
				return false;
			}
		} else if (!cost.equals(other.cost)) {
			return false;
		}
		if (name != other.name) {
			return false;
		}
		if (transparency != other.transparency) {
			return false;
		}
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return name + ", id = " + id + ", weight = " + weight + " carat, cost = $" + cost + ", " + transparency;
	}
}
