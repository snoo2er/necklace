package by.hryshchanka.task2.comparator;

import java.util.Comparator;

import by.hryshchanka.task2.entity.Gem;

public class GemTransparencyComparator implements Comparator<Gem> {
	public int compare(Gem gem1, Gem gem2) {
		return gem1.getTransparency().compareTo(gem2.getTransparency());
	}
}
