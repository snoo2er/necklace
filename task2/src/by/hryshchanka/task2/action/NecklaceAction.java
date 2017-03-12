package by.hryshchanka.task2.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import by.hryshchanka.task2.entity.Gem;
import by.hryshchanka.task2.entity.Necklace;
import by.hryshchanka.task2.entity.Transparency;

public class NecklaceAction {
	
	public static void sortNecklaceGemsByParameter(Necklace necklace, Comparator<Gem> comparator) {
		Collections.sort(necklace.getGems(), comparator);
	}
		
	public static ArrayList<Gem> findGemsWithTransparency(Necklace necklace, Transparency transparency) {
		ArrayList<Gem> gems = new ArrayList<>();
		for (Gem gem : necklace.getGems()) {
			if (gem.getTransparency().equals(transparency)) {
				gems.add(gem);
			}
		}
		return gems;
	}
}
