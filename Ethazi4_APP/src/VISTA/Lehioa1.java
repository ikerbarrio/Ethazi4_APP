package VISTA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import APP.MetodoakVista;

public class Lehioa1 extends JFrame {

	private JButton btnOngiEtorri = new JButton("ONGI ETORRI");
	private ActionListener al;

	/**
	 * Create the frame.
	 */
	public Lehioa1() {
		
		getContentPane().setLayout(null);
		this.setSize(478, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 635, 455);
		
		btnOngiEtorri.setFont(new Font("Tahoma", Font.BOLD, 35));
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MetodoakVista.bigarrenera();
			}
		};
		btnOngiEtorri.addActionListener(al);
		btnOngiEtorri.setBounds(0, 0, 619, 416);
		getContentPane().add(btnOngiEtorri);
	}

}
