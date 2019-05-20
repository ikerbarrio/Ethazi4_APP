package VISTA;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import APP.*;

public class LehioaAzkena extends JFrame {
	private ActionListener alBAzkena;
	private JButton btnAurrera = new JButton("ESKERRIK \r\nASKO");
	private ActionListener alBAurrera;

	/**
	 * Create the panel.
	 */
	public LehioaAzkena() {
		
		getContentPane().setLayout(null);
		
		
		btnAurrera.setFont(new Font("Tahoma", Font.BOLD, 50));
		btnAurrera.setBounds(0, 0, 619, 417);
		getContentPane().add(btnAurrera);
		this.setSize(478,300);  
		this.setLocationRelativeTo(null);  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 635, 455);
		
		alBAurrera = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				MetodoakVista.bueltatuLehena();
				dispose();
			}
		};
		btnAurrera.addActionListener(alBAurrera);
		

	}
}
