package model;

public class Tecla {
	private String keycode;
	private String pressionada;
	private String solta;
	
	public Tecla(String k, String p) {
		keycode = k;
		pressionada = p;
	}

	public String getKeycode() {
		return keycode;
	}

	public void setKeycode(String keycode) {
		this.keycode = keycode;
	}

	public String getPressionada() {
		return pressionada;
	}

	public void setPressionada(String pressionada) {
		this.pressionada = pressionada;
	}

	public String getSolta() {
		return solta;
	}

	public void setSolta(String solta) {
		this.solta = solta;
	}
	
}
