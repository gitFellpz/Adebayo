package br.com.adebayo.connection;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	private static String ORACLE = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private static DataSource conexao = null;
	
	private ConnectionFactory() {
		
	}

	public static Connection conectar() throws SQLException{
		if(conexao == null) {
			//Otimizar o acesso ao BD
			final ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
			comboPooledDataSource.setJdbcUrl(ORACLE);
			comboPooledDataSource.setUser("rm93015");
			comboPooledDataSource.setPassword("010104");
			
			//Número máximo de conexões
			comboPooledDataSource.setMaxPoolSize(10);
			conexao = comboPooledDataSource;
		}
		
		return conexao.getConnection();
	};
}
