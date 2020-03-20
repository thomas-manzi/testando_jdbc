package teste_jdbc;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		List l = new ArrayList();
		conecta_jdbc c = new conecta_jdbc();
		c.conectar();
		if (c.estaConectado()) {
			c.listarContato();
			//c.inserirContato("Pablo", "2020-2020");
			//c.inserirContato("Eveuca", "9220-2933");
			//c.updateContato(1, "thomas", "97712-7012");
			//c.deleteContato(6);
			c.desconectar();
		}

	}

}
