import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Estudos extends JFrame {
	public Estudos() {
		super("Eventos do Mouse e keyboard");
		Container c = getContentPane();
		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		c.setLayout(layout);
		keyboard keyboard = new keyboard();
		this.addKeyListener(keyboard);
		setSize(350, 250);
		setVisible(true);

	public static void main(String args[]) {
		Estudos app = new Estudos();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


class keyboard implements KeyListener {
	
	long pressedMillis, idleMillis = 0;
	int lastKey = -1; 
	boolean isRunning = false;
	
	public void keyPressed(KeyEvent e) {
		//ts idle stop if is running
		int keyCode = e.getKeyCode();
		
		/*if(isRunning && keyCode != lastKey) {
			long current = System.currentTimeMillis();
			idleMillis = current - idleMillis; //Get idle 
			System.out.println("Idle pressed: " +current);
			System.out.println("Idle Millis: " +idleMillis); 
		} */
		if (keyCode != lastKey) {
			lastKey = keyCode;
			pressedMillis = System.currentTimeMillis(); 
			System.out.println("Pressionando");
		}
		if(!isRunning) 
			isRunning = true;
	}

	public void keyReleased(KeyEvent e) {
		System.out.println("Solto");
		lastKey = -1;
		/*pressedMillis = System.currentTimeMillis() - pressedMillis;
		idleMillis = System.currentTimeMillis();
		System.out.println("Idle millis released: " +idleMillis);  */
	}

	public void keyTyped(KeyEvent e) {
		
	}
}