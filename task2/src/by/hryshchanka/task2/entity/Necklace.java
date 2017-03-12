package by.hryshchanka.task2.entity;

import java.util.ArrayList;

public class Necklace {
	private ArrayList<Gem> gems;

	public Necklace(ArrayList<Gem> gems) {
		super();
		this.gems = gems;
	}
	
	public Necklace() {
		super();
	}

	public ArrayList<Gem> getGems() {
		return gems;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("\nNecklace: \n");
		for (Gem gem : gems) {
			sb.append(gem.toString() + "\n");
		}
		return sb.toString();
	}
}
