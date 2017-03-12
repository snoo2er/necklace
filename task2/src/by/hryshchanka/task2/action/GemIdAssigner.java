package by.hryshchanka.task2.action;

public class GemIdAssigner {

	private static long id;
		
	public static long assignId(){
		return id++;
	}
}
