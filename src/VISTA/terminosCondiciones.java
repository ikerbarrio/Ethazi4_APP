package VISTA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import APP.MetodoakVista;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;

public class terminosCondiciones extends JFrame {

	private ActionListener al;
	private ActionListener al2;
	private JPanel contentPane;
	private JButton btnAurrera = new JButton("AURRERA");
	private final JButton btnOnartu = new JButton("ONARTU");
	/**
	 * Create the frame.
	 * @param logela_kop 
	 * @param gelaMota 
	 * @param hotela 
	 * @param prezioFinala 
	 */
	public terminosCondiciones(double prezioFinala, String hotela, String gelaMota) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 635, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		btnAurrera.setBounds(520, 382, 89, 23);
		contentPane.add(btnAurrera);
		btnAurrera.setEnabled(false);
		
		al2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAurrera.setEnabled(true);
			}
		};
		btnOnartu.addActionListener(al2);
		
		al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MetodoakVista.saioaHastera(prezioFinala, hotela, gelaMota);
			}
		};
		btnAurrera.addActionListener(al);
		
		JTextPane txtpnTxttermicondi = new JTextPane();
		txtpnTxttermicondi.setText("T�rminos y Condiciones de Uso\r\n" + 
				"INFORMACI�N RELEVANTE\r\n" + 
				"Es requisito necesario para la adquisici�n de los productos que se ofrecen en este sitio, que lea y\r\n" + 
				"acepte los siguientes T�rminos y Condiciones que a continuaci�n se redactan. El uso de nuestros\r\n" + 
				"servicios as� como la compra de nuestros productos implicar� que usted ha le�do y aceptado los\r\n" + 
				"T�rminos y Condiciones de Uso en el presente documento. Todas los productos que son\r\n" + 
				"ofrecidos por nuestro sitio web pudieran ser creadas, cobradas, enviadas o presentadas por una\r\n" + 
				"p�gina web tercera y en tal caso estar�an sujetas a sus propios T�rminos y Condiciones. En\r\n" + 
				"algunos casos, para adquirir un producto, ser� necesario el registro por parte del usuario, con\r\n" + 
				"ingreso de datos personales fidedignos y definici�n de una contrase�a.\r\n" + 
				"El usuario puede elegir y cambiar la clave para su acceso de administraci�n de la cuenta en\r\n" + 
				"cualquier momento, en caso de que se haya registrado y que sea necesario para la compra de\r\n" + 
				"alguno de nuestros productos. WWW.GRUPO1.COM no asume la responsabilidad en caso de\r\n" + 
				"que entregue dicha clave a terceros.\r\n" + 
				"Todas las compras y transacciones que se lleven a cabo por medio de este sitio web, est�n\r\n" + 
				"sujetas a un proceso de confirmaci�n y verificaci�n, el cual podr�a incluir la verificaci�n del stock y\r\n" + 
				"disponibilidad de producto, validaci�n de la forma de pago, validaci�n de la factura (en caso de\r\n" + 
				"existir) y el cumplimiento de las condiciones requeridas por el medio de pago seleccionado. En\r\n" + 
				"algunos casos puede que se requiera una verificaci�n por medio de correo electr�nico.\r\n" + 
				"Los precios de los productos ofrecidos en esta Tienda Online es v�lido solamente en las compras\r\n" + 
				"realizadas en este sitio web.\r\n" + 
				"LICENCIA\r\n" + 
				"GRUPO1 a trav�s de su sitio web concede una licencia para que los usuarios utilicen los\r\n" + 
				"productos que son vendidos en este sitio web de acuerdo a los T�rminos y Condiciones que se\r\n" + 
				"describen en este documento.\r\n" + 
				"USO NO AUTORIZADO\r\n" + 
				"En caso de que aplique (para venta de software, templetes, u otro producto de dise�o y\r\n" + 
				"programaci�n) usted no puede colocar uno de nuestros productos, modificado o sin modificar, en\r\n" + 
				"un CD, sitio web o ning�n otro medio y ofrecerlos para la redistribuci�n o la reventa de ning�n tipo.\r\n" + 
				"PROPIEDAD\r\n" + 
				"Usted no puede declarar propiedad intelectual o exclusiva a ninguno de nuestros productos,\r\n" + 
				"modificado o sin modificar. Todos los productos son propiedad de los proveedores del contenido.\r\n" + 
				"En caso de que no se especifique lo contrario, nuestros productos se proporcionan sin ning�n\r\n" + 
				"tipo de garant�a, expresa o impl�cita. En ning�n esta compa��a ser� responsables de ning�n da�o\r\n" + 
				"incluyendo, pero no limitado a, da�os directos, indirectos, especiales, fortuitos o consecuentes u\r\n" + 
				"otras p�rdidas resultantes del uso o de la imposibilidad de utilizar nuestros productos.\r\n" + 
				"POL�TICA DE REEMBOLSO Y GARANT�A\r\n" + 
				"En el caso de productos que sean mercanc�as irrevocables no-tangibles, no realizamos\r\n" + 
				"reembolsos despu�s de que se env�e el producto, usted tiene la responsabilidad de entender\r\n" + 
				"antes de comprarlo. Le pedimos que lea cuidadosamente antes de comprarlo. Hacemos\r\n" + 
				"solamente excepciones con esta regla cuando la descripci�n no se ajusta al producto. Hay\r\n" + 
				"algunos productos que pudieran tener garant�a y posibilidad de reembolso pero este ser�\r\n" + 
				"especificado al comprar el producto. En tales casos la garant�a solo cubrir� fallas de f�brica y s�lo\r\n" + 
				"se har� efectiva cuando el producto se haya usado correctamente. La garant�a no cubre aver�as o\r\n" + 
				"da�os ocasionados por uso indebido. Los t�rminos de la garant�a est�n asociados a fallas de\r\n" + 
				"fabricaci�n y funcionamiento en condiciones normales de los productos y s�lo se har�n efectivos\r\n" + 
				"estos t�rminos si el equipo ha sido usado correctamente. Esto incluye:\r\n" + 
				"� De acuerdo a las especificaciones t�cnicas indicadas para cada producto.\r\n" + 
				"� En condiciones ambientales acorde con las especificaciones indicadas por el fabricante.\r\n" + 
				"� En uso espec�fico para la funci�n con que fue dise�ado de f�brica.\r\n" + 
				"� En condiciones de operaci�n el�ctricas acorde con las especificaciones y tolerancias indicadas.\r\n" + 
				"COMPROBACI�N ANTIFRAUDE\r\n" + 
				"La compra del cliente puede ser aplazada para la comprobaci�n antifraude. Tambi�n puede ser\r\n" + 
				"suspendida por m�s tiempo para una investigaci�n m�s rigurosa, para evitar transacciones\r\n" + 
				"fraudulentas.\r\n" + 
				"PRIVACIDAD\r\n" + 
				"Este sitio web WWW.GRUPO1.COM garantiza que la informaci�n personal que usted env�a\r\n" + 
				"cuenta con la seguridad necesaria. Los datos ingresados por usuario o en el caso de requerir una\r\n" + 
				"validaci�n de los pedidos no ser�n entregados a terceros, salvo que deba ser revelada en\r\n" + 
				"cumplimiento a una orden judicial o requerimientos legales.\r\n" + 
				"La suscripci�n a boletines de correos electr�nicos publicitarios es voluntaria y podr�a ser\r\n" + 
				"seleccionada al momento de crear su cuenta.\r\n" + 
				"GRUPO1 reserva los derechos de cambiar o de modificar estos t�rminos sin previo aviso.\r\n" + 
				"Estas terminos y condiciones se han generado en terminosycondicionesdeusoejemplo.com.");
		txtpnTxttermicondi.setBounds(10, 11, 583, 328);
		contentPane.add(txtpnTxttermicondi);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(592, 11, 17, 328);
		contentPane.add(scrollBar);
		btnOnartu.setBounds(534, 350, 75, 23);
		
		contentPane.add(btnOnartu);
	}
}
