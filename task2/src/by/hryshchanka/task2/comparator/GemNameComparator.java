package by.hryshchanka.task2.comparator;

import java.util.Comparator;

import by.hryshchanka.task2.entity.Gem;

public class GemNameComparator implements Comparator<Gem> {
	public int compare(Gem gem1, Gem gem2) {
		return gem1.getName().compareTo(gem2.getName());
	}
}
