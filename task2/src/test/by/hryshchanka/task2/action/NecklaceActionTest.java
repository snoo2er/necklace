package test.by.hryshchanka.task2.action;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import by.hryshchanka.task2.action.NecklaceAction;
import by.hryshchanka.task2.comparator.GemCostComparator;
import by.hryshchanka.task2.entity.Clarity;
import by.hryshchanka.task2.entity.Gem;
import by.hryshchanka.task2.entity.GemName;
import by.hryshchanka.task2.entity.NaturalStone;
import by.hryshchanka.task2.entity.Necklace;
import by.hryshchanka.task2.entity.Pearl;
import by.hryshchanka.task2.entity.Transparency;

public class NecklaceActionTest {
	public static Necklace necklace;
	public static Gem testGemOne = new NaturalStone(GemName.DIAMOND, 1.5, new BigDecimal(1000), Transparency.TRANSPARENT, Clarity.I1);
	public static Gem testGemTwo = new Pearl(GemName.PEARL, new Double(5.0), new BigDecimal(50), Transparency.OPAQUE, 9.0);
	public static Gem testGemThree = new NaturalStone(GemName.DIAMOND, 1.5, new BigDecimal(1500), Transparency.TRANSPARENT, Clarity.I1);
	public static Gem testGemFour = new Pearl(GemName.PEARL, new Double(5.0), new BigDecimal(150), Transparency.OPAQUE, 9.0);
	
	@BeforeClass
	public static void initNecklace() {
		necklace = new Necklace(new ArrayList<Gem>());
		necklace.getGems().add(testGemOne);
		necklace.getGems().add(testGemTwo);
		necklace.getGems().add(testGemThree);
		necklace.getGems().add(testGemFour);
	}
	
	@Test
	public void sortNecklaceGemsByParameterTest() {
		NecklaceAction.sortNecklaceGemsByParameter(necklace, new GemCostComparator());
		boolean expected = true;
		boolean actual = necklace.getGems().get(0).equals(testGemTwo);
		assertThat(expected, equalTo(actual));
	}
	
	@Test
	public void findGemsWithTransparencyTest() {
		ArrayList<Gem> actual = NecklaceAction.findGemsWithTransparency(necklace, Transparency.OPAQUE);
		assertThat(actual, allOf(hasItem(testGemTwo), hasItem(testGemFour)));
	}
	
	@Test
	public void gemsWithTransparencySizeTest() {
		int sizeExpected = 2;
		ArrayList<Gem> actual = NecklaceAction.findGemsWithTransparency(necklace, Transparency.OPAQUE);
		assertThat(actual.size(), equalTo(sizeExpected));
	}
}
