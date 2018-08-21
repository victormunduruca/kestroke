package model;

import java.util.ArrayList;

public class Pessoa {
	private String idade;
	private ArrayList<Tecla> resultados = new ArrayList<Tecla>();
	
	public Pessoa(String i) {
		idade = i;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public ArrayList<Tecla> getResultados() {
		return resultados;
	}

	public void setResultados(ArrayList<Tecla> resultados) {
		this.resultados = resultados;
	}
}
