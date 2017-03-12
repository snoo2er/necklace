package test.by.hryshchanka.task2.parser;

import org.junit.Test;

import by.hryshchanka.task2.parser.GemParser;

public class GemParserTest {
	private static String[] exceptionString = {"pearl", "15", "100", "transparent", "ant1"};
	
	@Test(expected = IllegalArgumentException.class)
	public void createPreciousStoneFieldsExceptionTest() {
		GemParser.createPreciousStoneFields(exceptionString);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createAmberFieldsExceptionTest() {
		GemParser.createAmberFields(exceptionString);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createPearlFieldsExceptionTest() {
		GemParser.createPearlFields(exceptionString);
	}
}