package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.Controller;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class Window {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 545, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Digite a sua idade");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getKeyCode() == 10) {
					Controller.getInstance().setAge(Integer.parseInt(textField.getText()));
					SecondWindow second = new SecondWindow();
					second.setVisible(true);
					frame.setVisible(false);
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().setAge(Integer.parseInt(textField.getText()));
				SecondWindow second = new SecondWindow();
				second.setVisible(true);
				frame.setVisible(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(202)
					.addComponent(lblNewLabel)
					.addContainerGap(202, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(247, Short.MAX_VALUE)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(245))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(222, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(220))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(219, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
