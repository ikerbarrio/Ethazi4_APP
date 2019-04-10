package APP;

import VISTA.LehioaAzkena;
import VISTA.OngiEtorri;
import VISTA.Ordainketa;
import VISTA.SaioaHasi;
import VISTA.SaioaSortu;

public class MetodoakVista {
	public static void bueltatuLehena() {
		OngiEtorri ongiEtorri = new OngiEtorri();
		ongiEtorri.setVisible(true);
		ongiEtorri.setBounds(550, 200, 642, 467);
}

	public static void bigarrenera() {
		SaioaHasi saioaHasi = new SaioaHasi();
		saioaHasi.setVisible(true);
		saioaHasi.setBounds(550, 200, 642, 467);
	}
	
	public static void hirugarrenera() {
		SaioaSortu saioaSortu = new SaioaSortu();
		saioaSortu.setVisible(true);
		saioaSortu.setBounds(550, 200, 642, 467);
	}
	
	public static void laugarrenera(double prezioFinala) {
		Ordainketa ordainketa = new Ordainketa(prezioFinala);
		ordainketa.setVisible(true);
		ordainketa.setBounds(550, 200, 642, 467);
	}
	
	public static void azkenera() {
		LehioaAzkena azkena = new LehioaAzkena();
		azkena.setVisible(true);
		azkena.setBounds(550, 200, 642, 467);
	}
}
