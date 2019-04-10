package VISTA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import APP.MetodoakVista;

public class SaioaSortu extends JFrame {

	private JPanel contentPane;
	private JButton btnAurrera = new JButton("AURRERA");
	private ActionListener alBAurrera;

	/**
	 * Create the frame.
	 */
	public SaioaSortu() {
		this.setSize(478, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 635, 455);
		getContentPane().setLayout(null);
		
		
		btnAurrera.setBounds(520, 393, 89, 23);
		getContentPane().add(btnAurrera);
		
		alBAurrera = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MetodoakVista.hirugarrenera();
				dispose();
			
		};
		};
		btnAurrera.addActionListener(alBAurrera);
	}
}
