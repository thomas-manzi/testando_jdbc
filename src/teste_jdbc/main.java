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
			//c.updateContato(1, "seila", "3213-3213");
			//c.deleteContato(5);
			c.desconectar();
		}

	}

}
