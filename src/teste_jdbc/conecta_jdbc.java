package teste_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.Statement;

public class conecta_jdbc {
	private Connection connection= null;
	private Statement statement = null;
	private ResultSet resultSet= null;
	
	public void conectar () {
		String servidor = "jdbc:mysql://127.0.0.1:3306/agenda";
		String usuario = "root";
		String senha = "thomaswm123";
		//String driver = ".com.mysql.jdbc.Driver";
		try {
			//Class.forName(driver);
			this.connection= DriverManager.getConnection(servidor+"?useTimezone=true&serverTimezone=UTC", usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {
			System.out.println("Erro:"+ e.getMessage());
		}
	}
	public boolean estaConectado(){
		if(this.connection != null){
			return true;
		}else {
			return false;
		}
	}
	public void listarContato() {
		try {
			String query = "select * from contato order by id";
			this.resultSet= this.statement.executeQuery(query);
			while (this.resultSet.next()) {
				System.out.println("ID: "+ this.resultSet.getString("id") + " - Nome: "+ this.resultSet.getString("nome")+ " Telefone "+ this.resultSet.getString("telefone"));
			}
		} catch (Exception e) {
			System.out.println("erro : "+ e.getMessage());
		}
	}
	
	
	public void inserirContato(String nome, String telefone){
		try {
			String query= "insert into contato (nome,telefone) values ('" + nome+ "', '" + telefone +"');";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void updateContato(int id, String nome , String telefone){
		try {
			String query= "update contato set nome = '" + nome + "' , telefone = '" + telefone + "' where id = " + id + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("erro : " + e.getMessage());
		}
	}
	
	public void deleteContato(int id){
		try {
			String query = "delete from contato where id = " +id + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("erro :"+ e.getMessage());
		}
	}
	
	
	public void desconectar(){
		try {
			this.connection.close();
		} catch (Exception e) {
			System.out.println("erro: " + e.getMessage());
		}
	}

}
