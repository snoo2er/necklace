package by.hryshchanka.task2.factory;

import by.hryshchanka.task2.entity.SyntheticStone;


public class SyntheticStoneFactory extends AbstractGemFactory {
	public SyntheticStone createInstance() {
		return new SyntheticStone();
	}
}
