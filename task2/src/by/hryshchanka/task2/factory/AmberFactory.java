package by.hryshchanka.task2.factory;

import by.hryshchanka.task2.entity.Amber;

public class AmberFactory extends AbstractGemFactory{
	public Amber createInstance() {
		return new Amber();
	}
}
