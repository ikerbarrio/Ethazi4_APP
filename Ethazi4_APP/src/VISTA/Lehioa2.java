package VISTA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Lehioa2 extends JFrame {

	private JPanel contentPane;

	public Lehioa2() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		comboHotelak.setBounds(20, 182, 168, 31);
		
		for(int n = 0; n < hotelak.size(); n++) {
			comboHotelak.addItem(hotelak.get(n));
		}
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboHotelak.getItemCount()!=0) {						
							
					txtInformazioa.setText(Kontsultak.hotelInformazioaPantailaratu(comboHotelak.getSelectedItem().toString()));
				}	
			
			}
		};
		comboHotelak.addActionListener(al);
		getContentPane().add(comboHotelak);
		

		getContentPane().add(lblHotelak);
		
		lblAukeratu.setHorizontalAlignment(SwingConstants.CENTER);
		lblAukeratu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAukeratu.setBounds(63, 61, 215, 41);
		getContentPane().add(lblAukeratu);
		
		comboHiria.setBounds(265, 65, 168, 31);
		getContentPane().add(comboHiria);
		
		
		btnAurrera.setBounds(530, 393, 89, 23);
		getContentPane().add(btnAurrera);
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gauKopurua=(int)spinerGauKopurua.getValue();
				System.out.println(gauKopurua);
				prezioFinala=20*gauKopurua;
				System.out.println(prezioFinala);
				
				for(int i=0;i<hotelak.size();i++) {
					if(comboHotelak.getSelectedItem().equals(hotelak.get(i))) {
						m.fitxeroaIdatzi(hotelak.get(i).toString(), prezioFinala);
					}
				}
				if (comboHotelak.getSelectedItem() == null || comboHiria.getSelectedItem() == null){
					btnAurrera.setEnabled(false);
				}else{
					btnAurrera.setEnabled(true);
				}
			//	m.fitxeroaIdatzi("aeiou");
				m.FitxeroaIrakurri();
				dispose();
				MetodoakVista.hirugarrenera(prezioFinala);
			}
		};
		btnAurrera.addActionListener(al);
		btnAtzera.setBounds(0, 0, 89, 23);
		getContentPane().add(btnAtzera);
		
		
		txtInformazioa.setEditable(false);
		txtInformazioa.setBounds(265, 136, 315, 123);
		getContentPane().add(txtInformazioa);
		txtInformazioa.setColumns(10);
		
		
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MetodoakVista.bueltatuLehena();
			}
		});
	}

	}

}
