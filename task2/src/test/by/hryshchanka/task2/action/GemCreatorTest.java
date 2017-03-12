package test.by.hryshchanka.task2.action;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import by.hryshchanka.task2.action.CreatorException;
import by.hryshchanka.task2.action.GemCreator;
import by.hryshchanka.task2.entity.Clarity;
import by.hryshchanka.task2.entity.Gem;
import by.hryshchanka.task2.entity.GemName;
import by.hryshchanka.task2.entity.NaturalStone;
import by.hryshchanka.task2.entity.PreciousStoneType;
import by.hryshchanka.task2.entity.Transparency;

public class GemCreatorTest {
	public static GemCreator creator;
	public static ArrayList<Object[]> testFieldsList;
	
	@BeforeClass
	public static void initCreator() {
		creator = new GemCreator();
	}
	
	@AfterClass
	public static void clearAll() {
		creator = null;
		testFieldsList = null;
	}
	
	@Test
	public void createGemTest() {
		Gem expected = new NaturalStone(GemName.DIAMOND, 1.5, new BigDecimal(1000), Transparency.TRANSPARENT, Clarity.I1);
		Object[] testFields = {GemName.DIAMOND, 1.5, new BigDecimal(1000), Transparency.TRANSPARENT, PreciousStoneType.NATURAL, Clarity.I1};
		Gem actual = null;
		try {
			actual = creator.createGem(testFields);
		} catch (CreatorException e) {
			e.printStackTrace();
		}
		assertThat(expected, equalTo(actual));
	}

	
	@Before
	public void initTestList() {
		testFieldsList = new ArrayList<>();
		Object[] testFields1 = {GemName.DIAMOND, new Double(1.5), new BigDecimal(1000), Transparency.TRANSPARENT, PreciousStoneType.NATURAL, Clarity.I1};
		Object[] testFields2 = {GemName.PEARL, new Double(5.0), new BigDecimal(50), Transparency.OPAQUE, 9.0};
		testFieldsList.add(testFields1);
		testFieldsList.add(testFields2);
	}

	@Test
	public void createGemListTest() {
		Gem expected = new NaturalStone(GemName.DIAMOND, 1.5, new BigDecimal(1000), Transparency.TRANSPARENT, Clarity.I1);
		ArrayList<Gem> actual = creator.createGemList(testFieldsList);
		assertThat("no expected Gem ", actual, hasItem(expected));
	}
	
	@Test
	public void gemListSizeTest() {
		ArrayList<Gem> actual = creator.createGemList(testFieldsList);
		assertThat("wrong size", actual.size(), equalTo(2));
	}
}
