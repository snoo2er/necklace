package test.by.hryshchanka.task2.parser;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import by.hryshchanka.task2.entity.AmberInclusion;
import by.hryshchanka.task2.entity.Clarity;
import by.hryshchanka.task2.entity.GemName;
import by.hryshchanka.task2.entity.PreciousStoneType;
import by.hryshchanka.task2.entity.Transparency;
import by.hryshchanka.task2.parser.NecklaceParser;

public class NecklaceParseTest {
	private static NecklaceParser parser;
	private static List<String> testLines;
	
	@Before
	public void initData() {
		parser = new NecklaceParser();
		testLines = new ArrayList<>();
		testLines.add("Diamond 1.5 1000 transparent  natural i1");
		testLines.add("pearl 5 50 opaque 9");
		testLines.add("Diamond 5 50 opaque 9");
		testLines.add("amber 15 100 transparent ant");
		testLines.add("wrong 4 5000 transparent synthetic fl");
	}
	
	@After
    public void clear() {
		parser = null;
		testLines = null;
	}
	
	@Test
	public void createPreciousStoneFieldsTest() {
		Object[] exectedFields1 = {GemName.DIAMOND, 1.5, new BigDecimal(1000), Transparency.TRANSPARENT, PreciousStoneType.NATURAL, Clarity.I1};
		Object[] exectedFields2 = {GemName.PEARL, 5.0, new BigDecimal(50), Transparency.OPAQUE, 9.0};
		Object[] exectedFields3 = {GemName.AMBER, 15.0, new BigDecimal(100), Transparency.TRANSPARENT, AmberInclusion.ANT};
		ArrayList<Object[]> actual = parser.createGemFieldsList(testLines);
		assertThat(actual, allOf(hasItem(exectedFields1), hasItem(exectedFields2), hasItem(exectedFields3)));
	}
}
