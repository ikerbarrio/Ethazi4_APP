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
		txtpnTxttermicondi.setText("Términos y Condiciones de Uso\r\n" + 
				"INFORMACIÓN RELEVANTE\r\n" + 
				"Es requisito necesario para la adquisición de los productos que se ofrecen en este sitio, que lea y\r\n" + 
				"acepte los siguientes Términos y Condiciones que a continuación se redactan. El uso de nuestros\r\n" + 
				"servicios así como la compra de nuestros productos implicará que usted ha leído y aceptado los\r\n" + 
				"Términos y Condiciones de Uso en el presente documento. Todas los productos que son\r\n" + 
				"ofrecidos por nuestro sitio web pudieran ser creadas, cobradas, enviadas o presentadas por una\r\n" + 
				"página web tercera y en tal caso estarían sujetas a sus propios Términos y Condiciones. En\r\n" + 
				"algunos casos, para adquirir un producto, será necesario el registro por parte del usuario, con\r\n" + 
				"ingreso de datos personales fidedignos y definición de una contraseña.\r\n" + 
				"El usuario puede elegir y cambiar la clave para su acceso de administración de la cuenta en\r\n" + 
				"cualquier momento, en caso de que se haya registrado y que sea necesario para la compra de\r\n" + 
				"alguno de nuestros productos. WWW.GRUPO1.COM no asume la responsabilidad en caso de\r\n" + 
				"que entregue dicha clave a terceros.\r\n" + 
				"Todas las compras y transacciones que se lleven a cabo por medio de este sitio web, están\r\n" + 
				"sujetas a un proceso de confirmación y verificación, el cual podría incluir la verificación del stock y\r\n" + 
				"disponibilidad de producto, validación de la forma de pago, validación de la factura (en caso de\r\n" + 
				"existir) y el cumplimiento de las condiciones requeridas por el medio de pago seleccionado. En\r\n" + 
				"algunos casos puede que se requiera una verificación por medio de correo electrónico.\r\n" + 
				"Los precios de los productos ofrecidos en esta Tienda Online es válido solamente en las compras\r\n" + 
				"realizadas en este sitio web.\r\n" + 
				"LICENCIA\r\n" + 
				"GRUPO1 a través de su sitio web concede una licencia para que los usuarios utilicen los\r\n" + 
				"productos que son vendidos en este sitio web de acuerdo a los Términos y Condiciones que se\r\n" + 
				"describen en este documento.\r\n" + 
				"USO NO AUTORIZADO\r\n" + 
				"En caso de que aplique (para venta de software, templetes, u otro producto de diseño y\r\n" + 
				"programación) usted no puede colocar uno de nuestros productos, modificado o sin modificar, en\r\n" + 
				"un CD, sitio web o ningún otro medio y ofrecerlos para la redistribución o la reventa de ningún tipo.\r\n" + 
				"PROPIEDAD\r\n" + 
				"Usted no puede declarar propiedad intelectual o exclusiva a ninguno de nuestros productos,\r\n" + 
				"modificado o sin modificar. Todos los productos son propiedad de los proveedores del contenido.\r\n" + 
				"En caso de que no se especifique lo contrario, nuestros productos se proporcionan sin ningún\r\n" + 
				"tipo de garantía, expresa o implícita. En ningún esta compañía será responsables de ningún daño\r\n" + 
				"incluyendo, pero no limitado a, daños directos, indirectos, especiales, fortuitos o consecuentes u\r\n" + 
				"otras pérdidas resultantes del uso o de la imposibilidad de utilizar nuestros productos.\r\n" + 
				"POLÍTICA DE REEMBOLSO Y GARANTÍA\r\n" + 
				"En el caso de productos que sean mercancías irrevocables no-tangibles, no realizamos\r\n" + 
				"reembolsos después de que se envíe el producto, usted tiene la responsabilidad de entender\r\n" + 
				"antes de comprarlo. Le pedimos que lea cuidadosamente antes de comprarlo. Hacemos\r\n" + 
				"solamente excepciones con esta regla cuando la descripción no se ajusta al producto. Hay\r\n" + 
				"algunos productos que pudieran tener garantía y posibilidad de reembolso pero este será\r\n" + 
				"especificado al comprar el producto. En tales casos la garantía solo cubrirá fallas de fábrica y sólo\r\n" + 
				"se hará efectiva cuando el producto se haya usado correctamente. La garantía no cubre averías o\r\n" + 
				"daños ocasionados por uso indebido. Los términos de la garantía están asociados a fallas de\r\n" + 
				"fabricación y funcionamiento en condiciones normales de los productos y sólo se harán efectivos\r\n" + 
				"estos términos si el equipo ha sido usado correctamente. Esto incluye:\r\n" + 
				"– De acuerdo a las especificaciones técnicas indicadas para cada producto.\r\n" + 
				"– En condiciones ambientales acorde con las especificaciones indicadas por el fabricante.\r\n" + 
				"– En uso específico para la función con que fue diseñado de fábrica.\r\n" + 
				"– En condiciones de operación eléctricas acorde con las especificaciones y tolerancias indicadas.\r\n" + 
				"COMPROBACIÓN ANTIFRAUDE\r\n" + 
				"La compra del cliente puede ser aplazada para la comprobación antifraude. También puede ser\r\n" + 
				"suspendida por más tiempo para una investigación más rigurosa, para evitar transacciones\r\n" + 
				"fraudulentas.\r\n" + 
				"PRIVACIDAD\r\n" + 
				"Este sitio web WWW.GRUPO1.COM garantiza que la información personal que usted envía\r\n" + 
				"cuenta con la seguridad necesaria. Los datos ingresados por usuario o en el caso de requerir una\r\n" + 
				"validación de los pedidos no serán entregados a terceros, salvo que deba ser revelada en\r\n" + 
				"cumplimiento a una orden judicial o requerimientos legales.\r\n" + 
				"La suscripción a boletines de correos electrónicos publicitarios es voluntaria y podría ser\r\n" + 
				"seleccionada al momento de crear su cuenta.\r\n" + 
				"GRUPO1 reserva los derechos de cambiar o de modificar estos términos sin previo aviso.\r\n" + 
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
