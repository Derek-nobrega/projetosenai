package crud.db;
import java.sql.Connection;
import java.sql.DriverManager;

public class conexao {

	public static Connection conectar() throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://ruby.db.elephantsql.com:5432/txnxyrim";
			String userDB = "txnxyrim";
			String passDB = "iqWWuiodXJm2s0DIifFqgNWy4Kth03ij";
			return DriverManager.getConnection(url, userDB, passDB);
			
		} catch (Exception e) {
			System.out.println("Erro de conexçao");
			e.printStackTrace();
			return null;
		}
		
		

		
	}
	
}
