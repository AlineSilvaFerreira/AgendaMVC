package model;

import java.sql.DriverManager;
import java.sql.Connection;

public class Conexao {	
		
		private static String USERNAME = "root";
		private static String PASSWORD = "root";		
		private static String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
		
	  public static Connection createConnectionToMySQL() throws Exception{

	     Class.forName("com.mysql.cj.jdbc.Driver"); 

	     Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

	     return connection;

	  }

		public static void main(String[] args) throws Exception {
			
			Connection conn = createConnectionToMySQL();
			
			if (conn != null) {
				System.out.println(conn + "\n\n ****  Conexao obtida com sucesso!  ****");
				conn.close();
			}
		}
	}

