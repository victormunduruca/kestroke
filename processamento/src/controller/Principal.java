package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import model.Tecla;
import model.Pessoa;

public class Principal {
	
	public static ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
	
	public static String frase = new String("eu plantei uma semente e ela me contou uma piada.");
	public static ArrayList<String[]> auxiliar = new ArrayList<String[]>();
	public static String[] keycodes = new String[]{"69", "85", "32", "80", "76", "65", "78", "84", "69", "73", "32", "85", "77", "65", "32", "83", "69", "77", "69", "78", "84", "69", "32", "69", "32", "69", "76", "65", "32", "77", "69", "32", "67", "79", "78", "84", "79", "85", "32", "85", "77", "65", "32", "80", "73", "65", "68", "65", "46"};
	public static int k = 0;
	
	public static ArrayList<long[]> latencias = new ArrayList<long[]>();
	
	public static void main(String[] args) {
		String path = "dataset.txt";
		try {
			leitura(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		calcLatencias();
		
		
	}
	
	public static void leitura(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        String[] aux;
        
        while (true) {
        	linha = buffRead.readLine();
            if (linha != null) {
            	aux = linha.split("-");
            	
            	if(!(aux[0].equals(""))) {
            		auxiliar.add(aux);
            	}
            	
            	if(aux[0].equals("46") && aux[2].equals("released")) {
            		processamento();
            		k++;
            	}
            } else {
                break;
            }
        }
        buffRead.close();
	}
	
	public static void processamento() {
		int i = 0;
		int j = 0;
		Tecla t = null;
		
		Pessoa n = new Pessoa(auxiliar.get(0)[0]);
		lista.add(n);
		auxiliar.remove(0);
		
		while(i < keycodes.length) {
			if(auxiliar.get(j)[0].equals(keycodes[i])) {
				if(auxiliar.get(j)[2].equals("press")) {
					t = new Tecla(auxiliar.get(j)[0], auxiliar.get(j)[1]);
				} else {
					t.setSolta(auxiliar.get(j)[1]);
            		lista.get(k).getResultados().add(t);
            		i++;
				}
				auxiliar.remove(j);
				j = 0;
			} else {
				j++;
			}
		}
		auxiliar = new ArrayList<String[]>();
	}
	
	public static void vamoVer() {
		System.out.println("Vamo ver");
	}
	
	public static void calcLatencias() {
		long[] aux = new long[49];
		
		for(int i = 0; i < lista.size(); i++) {
			aux = new long[49];
			int o = 0;
			aux[0] = (Long.parseLong(lista.get(i).getIdade()));
			for(int j = 1; j < 49; j++) {
				aux[j] = Math.abs((Long.parseLong(lista.get(i).getResultados().get(o+1).getPressionada())) - (Long.parseLong(lista.get(i).getResultados().get(o).getPressionada())));
				o++;
			}
			latencias.add(aux);
		}
		try {
			gravaTxt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void gravaTxt() throws IOException{
		String algo = new String();
		File file = new File("latencias.txt");
	    FileWriter f = new FileWriter (file, true);
	    for(int i = 0; i < latencias.size(); i++) {
	    	for(int j = 0; j < latencias.get(i).length; j++) {
	    		algo = Long.toString(latencias.get(i)[j]);
	    		if((j+1) != latencias.get(i).length) {
	    			algo += ",";
	    		}
	    		f.write(algo);	
	    	}
	    	f.write("\n");
	    }
	    f.close(); 
		}
	}
