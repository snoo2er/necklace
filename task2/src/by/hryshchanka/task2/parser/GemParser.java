package by.hryshchanka.task2.parser;

import java.math.BigDecimal;

import by.hryshchanka.task2.entity.AmberInclusion;
import by.hryshchanka.task2.entity.Clarity;
import by.hryshchanka.task2.entity.GemName;
import by.hryshchanka.task2.entity.PreciousStoneType;
import by.hryshchanka.task2.entity.Transparency;

public class GemParser {
	private static final int GEM_NAME_FIELD = 0;
	private static final int GEM_WEIGHT_FIELD = 1;
	private static final int GEM_COST_FIELD = 2;
	private static final int GEM_TRANSPARENCY_FIELD = 3;
	
	private static final int PRECIOUS_STONE_TYPE_FIELD = 4;
	private static final int PRECIOUS_STONE_CLARITY_FIELD = 5;
	
	private static final int AMBER_INCLUSION_FIELD = 4;
	
	private static final int PEARL_DIAMETER_FIELD = 4;

	public static Object[] createPreciousStoneFields(String[] gem) throws IllegalArgumentException {
		Object[] preciousStoneFields = new Object[]{
			GemName.valueOf(gem[GEM_NAME_FIELD].toUpperCase()),
			Double.parseDouble(gem[GEM_WEIGHT_FIELD]),
			new BigDecimal(gem[GEM_COST_FIELD]),
			Transparency.valueOf(gem[GEM_TRANSPARENCY_FIELD].toUpperCase()),
			PreciousStoneType.valueOf(gem[PRECIOUS_STONE_TYPE_FIELD].toUpperCase()),
			Clarity.valueOf(gem[PRECIOUS_STONE_CLARITY_FIELD].toUpperCase())};
		return preciousStoneFields;
	}
	
	public static Object[] createAmberFields(String[] gem) throws IllegalArgumentException {
		Object[] preciousStoneFields = new Object[]{
			GemName.valueOf(gem[GEM_NAME_FIELD].toUpperCase()),
			Double.parseDouble(gem[GEM_WEIGHT_FIELD]),
			new BigDecimal(gem[GEM_COST_FIELD]),
			Transparency.valueOf(gem[GEM_TRANSPARENCY_FIELD].toUpperCase()),
			AmberInclusion.valueOf(gem[AMBER_INCLUSION_FIELD].toUpperCase())};
		return preciousStoneFields;
	}
	
	public static Object[] createPearlFields(String[] gem) throws IllegalArgumentException {
		Object[] preciousStoneFields = new Object[]{
			GemName.valueOf(gem[GEM_NAME_FIELD].toUpperCase()),
			Double.parseDouble(gem[GEM_WEIGHT_FIELD]),
			new BigDecimal(gem[GEM_COST_FIELD]),
			Transparency.valueOf(gem[GEM_TRANSPARENCY_FIELD].toUpperCase()),
			Double.parseDouble(gem[PEARL_DIAMETER_FIELD])};
		return preciousStoneFields;
	}
}
