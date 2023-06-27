package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Jogador;

public class DAOJogadorSQLITE implements DAOJogador {

	@Override
	public void addJogador(Jogador jogador, int idCampeonato) throws Exception {
		// TODO Auto-generated method stub
		 try (Connection conn = ConexaoBD.getIntancia().getConexao();) {
	            String query = "INSERT INTO jogador (nome, apelido, pontuacao) VALUES (?, ?, ?)";
	            PreparedStatement statement = conn.prepareStatement(query);
	            statement.setString(1, jogador.getNome());
	            statement.setString(2, 	jogador.getApelido());
	            statement.setInt(3, 	jogador.getPontuacaoTotal());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

/*
	@Override
	public void initJogadores() throws Exception {
		 try (Connection conn = ConexaoBD.getIntancia().getConexao();
		         PreparedStatement stmt = conn.prepareStatement("CREATE TABLE IF NOT EXISTS JOGADOR "
		         		+ "(id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(100), data DATE"
		        	)
		    	){
		        stmt.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
	}
*/
}
