package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controller.Controller;

public class KeyboardListener implements KeyListener{
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		long currentPressed = System.currentTimeMillis();
		System.out.println("Tecla Pressionada" +e.getKeyCode());
		Controller.getInstance().addKey(e.getKeyCode() + "-" + currentPressed + "-" + "press");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		long currentReleased = System.currentTimeMillis();
		Controller.getInstance().addKey(e.getKeyCode() + "-" + currentReleased + "-" + "released");
		System.out.println("Tecla Solta");
	}

}
