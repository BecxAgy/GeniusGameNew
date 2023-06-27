package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoBD {

	 private Connection conn;
	 
	 public Connection conectaBD() {
		 
	        try {
	            String url = "jdbc:sqlite:BancoGeniusGame.db";
	            conn = DriverManager.getConnection(url);
	            return conn;
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Falha ao conectar ao banco de dados: " + e.getMessage());
	        }
	        return null;
	    }

	    public void fecharConexao() {
	        try {
	            if (conn != null && !conn.isClosed()) {
	                conn.close();
	                JOptionPane.showMessageDialog(null, "Conexão fechada com sucesso!");
	            }
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + e.getMessage());
	        }
	    }


	    public static void main(String[] args) {
	        ConexaoBD conexaoBD = new ConexaoBD();
	        Connection conn = null;

	        try {
	            // Teste de conexão
	            conn = conexaoBD.conectaBD();
	            if (conn != null) {
	                JOptionPane.showMessageDialog(null, "Conexão estabelecida com sucesso!");
	            } else {
	                JOptionPane.showMessageDialog(null, "Falha ao conectar ao banco de dados.");
	            }
	        } finally {
	            conexaoBD.fecharConexao();
	        }
	    }
	}