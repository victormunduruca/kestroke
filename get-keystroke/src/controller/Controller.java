package controller;

import java.util.ArrayList;

public class Controller {
	private static Controller instanciaController;
	public ArrayList<String> keys = new ArrayList<String>();
	public int age = 0;
	private Controller() {
		
	}
	public void addKey(String newKey) {
		keys.add(newKey);
	}
	public void setAge(int age) {
		this.age = age;
	}
	public static Controller getInstance(){
		if(instanciaController == null) 
			instanciaController = new Controller();
		return instanciaController;
	}
	public void printArray() {
		for(String s : keys) {
			System.out.println(s);
		}
	}
}
