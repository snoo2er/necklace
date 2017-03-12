package by.hryshchanka.task2.factory;

import by.hryshchanka.task2.entity.NaturalStone;

public class NaturalStoneFactory extends AbstractGemFactory {
	public NaturalStone createInstance() {
		return new NaturalStone();
	}
}
