package by.hryshchanka.task2.factory;

import by.hryshchanka.task2.entity.Pearl;

public class PearlFactory extends AbstractGemFactory {
	public Pearl createInstance() {
		return new Pearl();
	}
}
