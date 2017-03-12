package by.hryshchanka.task2.action;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hryshchanka.task2.entity.Amber;
import by.hryshchanka.task2.entity.AmberInclusion;
import by.hryshchanka.task2.entity.Clarity;
import by.hryshchanka.task2.entity.Gem;
import by.hryshchanka.task2.entity.GemName;
import by.hryshchanka.task2.entity.NaturalStone;
import by.hryshchanka.task2.entity.Pearl;
import by.hryshchanka.task2.entity.PreciousStoneType;
import by.hryshchanka.task2.entity.SyntheticStone;
import by.hryshchanka.task2.entity.Transparency;
import by.hryshchanka.task2.factory.AbstractGemFactory;
import by.hryshchanka.task2.factory.AmberFactory;
import by.hryshchanka.task2.factory.NaturalStoneFactory;
import by.hryshchanka.task2.factory.PearlFactory;
import by.hryshchanka.task2.factory.SyntheticStoneFactory;


public class GemCreator {
	private static final Logger LOGGER = LogManager.getLogger(GemCreator.class);
	private static final int GEM_NAME_FIELD = 0;
	private static final int GEM_WEIGHT_FIELD = 1;
	private static final int GEM_COST_FIELD = 2;
	private static final int GEM_TRANSPARENCY_FIELD = 3;
	
	private static final int PRECIOUS_STONE_TYPE_FIELD = 4;
	private static final int PRECIOUS_STONE_CLARITY_FIELD = 5;
	
	private static final int AMBER_INCLUSION_FIELD = 4;
	
	private static final int PEARL_DIAMETER_FIELD = 4;
	
	private void initFields(Gem gem, Object[] obj) {
		gem.setId(GemIdAssigner.assignId());
		gem.setName((GemName)obj[GEM_NAME_FIELD]);
		gem.setCost((BigDecimal)obj[GEM_COST_FIELD]);
		gem.setTransparency((Transparency)obj[GEM_TRANSPARENCY_FIELD]);
		gem.setWeight((double)obj[GEM_WEIGHT_FIELD]);
	}
	
	public ArrayList<Gem> createGemList(ArrayList<Object[]> gemFieldsList){
		ArrayList<Gem> gems = new ArrayList<>();
		for (Object[] obj : gemFieldsList) {
			try {
				gems.add(createGem(obj));
			} catch (CreatorException | NullPointerException e) {
				LOGGER.log(Level.ERROR, "gem not created");
			}
		}
		return gems;
	}
	
	public Gem createGem(Object[] gemFields) throws CreatorException {
		AbstractGemFactory factory = null;
		GemName name = (GemName)gemFields[GEM_NAME_FIELD];
		if (name.equals(GemName.DIAMOND) || name.equals(GemName.RUBY) || 
				name.equals(GemName.EMERALD) || name.equals(GemName.SAPPHIRE)) {
			if (gemFields[PRECIOUS_STONE_TYPE_FIELD].equals(PreciousStoneType.NATURAL)) {
				factory = new NaturalStoneFactory();
				NaturalStone stone = (NaturalStone)factory.createInstance();
				initFields(stone, gemFields);
				stone.setClarity((Clarity)gemFields[PRECIOUS_STONE_CLARITY_FIELD]);
				return stone;
			}
			else {
				factory = new SyntheticStoneFactory();
				SyntheticStone stone = (SyntheticStone)factory.createInstance();
				initFields(stone, gemFields);
				stone.setClarity((Clarity)gemFields[PRECIOUS_STONE_CLARITY_FIELD]);
				return stone;
			}
		} else if (name.equals(GemName.AMBER)) {
			factory = new AmberFactory();
			Amber stone = (Amber)factory.createInstance();
			initFields(stone, gemFields);
			stone.setInclusion((AmberInclusion)gemFields[AMBER_INCLUSION_FIELD]);
			return stone;
		
		} else if (name.equals(GemName.PEARL)) {
			factory = new PearlFactory();
			Pearl stone = (Pearl)factory.createInstance();
			initFields(stone, gemFields);
			stone.setDiameter((double)gemFields[PEARL_DIAMETER_FIELD]);
			return stone;
		} else {
        throw new CreatorException();
		}
		
	}
}
