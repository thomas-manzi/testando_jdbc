package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class teste_jdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection conexao =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/teste_jdbc?useTimezone=true&serverTimezone=UTC","root","thomaswm123");
			System.out.println("conectado");
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
