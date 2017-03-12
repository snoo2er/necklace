package by.hryshchanka.task2.parser;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hryshchanka.task2.entity.GemName;

public class NecklaceParser {
	private static final Logger LOGGER = LogManager.getLogger(NecklaceParser.class);
	private static final int GEM_NAME_FIELD = 0;
	private static final int PRECIOUS_FIELD_QUANTITY = 6;
	private static final int AMBER_FIELD_QUANTITY = 5;
	private static final int PEARL_FIELD_QUANTITY = 5;
	
	public ArrayList<Object[]> createGemFieldsList (List<String> necklaceLines) {
		ArrayList<Object[]> gemFieldsList = new ArrayList<>();
		int wrongLineCounter = 0;
		for(String line: necklaceLines){
			String[] gem  = line.split("\\s+");
			Object[] gemFields = null;
			try {
				if(gem[GEM_NAME_FIELD].toUpperCase().equals(GemName.DIAMOND.name()) && gem.length == PRECIOUS_FIELD_QUANTITY ||
						gem[GEM_NAME_FIELD].toUpperCase().equals(GemName.EMERALD.name()) && gem.length == PRECIOUS_FIELD_QUANTITY || 
						gem[GEM_NAME_FIELD].toUpperCase().equals(GemName.RUBY.name()) && gem.length == PRECIOUS_FIELD_QUANTITY || 
						gem[GEM_NAME_FIELD].toUpperCase().equals(GemName.SAPPHIRE.name()) && gem.length == PRECIOUS_FIELD_QUANTITY) {
					gemFields = GemParser.createPreciousStoneFields(gem);
				} else if (gem[GEM_NAME_FIELD].toUpperCase().equals(GemName.AMBER.name()) && gem.length == AMBER_FIELD_QUANTITY) {
					gemFields = GemParser.createAmberFields(gem);
				} else if (gem[GEM_NAME_FIELD].toUpperCase().equals(GemName.PEARL.name()) && gem.length == PEARL_FIELD_QUANTITY) {
					gemFields = GemParser.createPearlFields(gem);
				} else {
					throw new ParserException();
				}
				gemFieldsList.add(gemFields);
			}
			catch (IllegalArgumentException | ParserException e) {
				LOGGER.log(Level.ERROR, e.toString() + " | wrong data on line " + (gemFieldsList.size() + 1 + wrongLineCounter++) + ", gem fields not parsed" );
			}
		}
		if (gemFieldsList.isEmpty()) {
			LOGGER.log(Level.ERROR, "all data is wrong, gems not created");
		}
		return gemFieldsList;
	}
}
