package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import exceptions.AgeMissingException;
import exceptions.invalidUserInputException;

public class Controller {
	private static Controller instanciaController;
	public ArrayList<String> keys = new ArrayList<String>();
	public int age = 0;
	public String desiredInput = "eu plantei uma semente e ela me contou uma piada.";
	
	
	private Controller() {
	
	}
	
	public static Controller getInstance(){
		if(instanciaController == null) 
			instanciaController = new Controller();
		return instanciaController;
	}
	
	public void addKey(String newKey) {
		keys.add(newKey);
	}
	public void setAge(int age) {
		this.age = age;
	}

	public void validateUserInput(String userInput) throws invalidUserInputException {
		if(!userInput.equals(desiredInput)) {
			throw new invalidUserInputException();
		}
	}
	
	public void printArray() {
		for(String s : keys) {
			System.out.println(s);
		}
	}
	public void updateDataBase() throws AgeMissingException, IOException {
		
		try(FileWriter fw = new FileWriter("database.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw))
		{	
			if(age != 0) 
				out.println(age);
			else 
				throw new AgeMissingException();
			for(String key : keys) {
				out.println(key);
			}
			out.println();
			
		} catch (IOException e) {
			
		}
	}

	public void resetArray() {
		keys.clear();	
	}
}
