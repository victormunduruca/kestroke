package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import exceptions.AgeMissingException;
import exceptions.invalidUserInputException;

public class SecondWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondWindow frame = new SecondWindow();	
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SecondWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		JButton btnNewButton = new JButton("Pr�ximo\n");
		JEditorPane editorPane = new JEditorPane();
		KeyboardListener keyboard = new KeyboardListener();
		editorPane.addKeyListener(keyboard);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//escreve dados pelo controller
				Controller.getInstance().printArray();
				try {
					Controller.getInstance().validateUserInput(editorPane.getText());
					Controller.getInstance().updateDataBase();
					JOptionPane.showMessageDialog(null, "Muito obrigado por participar! Tenha um �timo dia :)", "Tudo ok", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
				} catch (AgeMissingException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Por favor, insira sua idade", "Erro!", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (invalidUserInputException e1) {
					JOptionPane.showMessageDialog(null, "Por favor, digite a mensagem corretamente", "Erro!", JOptionPane.ERROR_MESSAGE);
					Controller.getInstance().resetArray();
					editorPane.setText("");
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("<html>eu plantei uma semente e ela me contou uma piada.</html>");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(223, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(212))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(editorPane, Alignment.LEADING)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addComponent(lblNewLabel)
					.addGap(38)
					.addComponent(editorPane, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(51))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
}
