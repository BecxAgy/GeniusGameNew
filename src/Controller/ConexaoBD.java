package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;



public class ConexaoBD {

  
    	private Connection conexao;
    	private static ConexaoBD instancia;
    	
    	ConexaoBD() throws SQLException {
    		String url="jdbc:sqlite:BancoGeniusGame.db";
    		this.conexao=DriverManager.getConnection(url);
    	}

    	public static ConexaoBD getIntancia() throws SQLException {
    		if(instancia==null)
    			instancia=new ConexaoBD();
    		return instancia;
    	}
    	
    	public Connection getConexao() throws SQLException {
    		return conexao;
    	}
    	
    	 public Connection conectaBD () {
    	    	
    	    	Connection conn= null;
    	    	try {
    	    		
    	    		String url="jdbc:sqlite:BancoGeniusGame.db";
    	    		
    	    		conn=DriverManager.getConnection(url);
    				
    			} catch (SQLException erro) {
    				
    				 JOptionPane.showMessageDialog(null, "  ConexaoDAO  " + erro.getMessage());
    			}
    	    	
    	    	return conn;
    	    }

    	 public static void main(String[] args) throws SQLException {
    	        ConexaoBD conexaoBD = new ConexaoBD();

    	        // Teste de conexão
    	        Connection conn = conexaoBD.conectaBD();
    	        if (conn != null) {
    	            JOptionPane.showMessageDialog(null, "Conexão estabelecida com sucesso!");
    	        } else {
    	            JOptionPane.showMessageDialog(null, "Falha ao conectar ao banco de dados.");
    	        }

    	        // Fechando a conexão
    	        try {
    	            if (conn != null) {
    	                conn.close();
    	            }
    	        } catch (SQLException e) {
    	            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + e.getMessage());
    	        }
    	    }
    	

}