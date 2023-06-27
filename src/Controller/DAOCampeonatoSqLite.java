package Controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Campeonato;
import Model.Jogador;


public class DAOCampeonatoSqLite  implements DAOCampeonato {

	@Override
	public void addCampeonato(Campeonato campeonato) throws Exception {
		

	}

	public ArrayList<Campeonato> getAllCampeonatos() {
	    ArrayList<Campeonato> campeonatos = new ArrayList<>();
	    
	    try (Connection conn = ConexaoBD.getIntancia().getConexao();
	         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM campeonato");
	         ResultSet rs = stmt.executeQuery()) {
	        
	        while (rs.next()) {
	            int campeonatoId = rs.getInt("id");
	            
	            // Criar um novo objeto Campeonato
	            Campeonato campeonato = new Campeonato(null, 0);
	            campeonato.setId(campeonatoId);
	            campeonato.setNome(rs.getString("nome"));
	            campeonato.setData(rs.getDate("data"));
	            
	            // Obter os jogadores do campeonato atual
	            ArrayList<Jogador> jogadores = getJogadoresByCampeonatoId(campeonatoId);
	            campeonato.setJogadores(jogadores);
	            
	            campeonatos.add(campeonato);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return campeonatos;
	}

	public ArrayList<Jogador> getJogadoresByCampeonatoId(int campeonatoId) {
	    ArrayList<Jogador> jogadores = new ArrayList<>();
	    
	    try (Connection conn = ConexaoBD.getIntancia().getConexao();
	         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM jogadores WHERE campeonato_id = " + campeonatoId);
	         
	         ResultSet rs = stmt.executeQuery()) {
	        
	        while (rs.next()) {
	            Jogador jogador = new Jogador();
	            jogador.setId(rs.getInt("id"));
	            jogador.setNome(rs.getString("nome"));
	            // Define outras informações do jogador, se necessário
	            
	            jogadores.add(jogador);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return jogadores;
	}


	@Override
	public void initCampeonato() {
	    try (Connection conn = ConexaoBD.getIntancia().getConexao();
	         PreparedStatement stmt = conn.prepareStatement("CREATE TABLE IF NOT EXISTS CAMPEONATO "
	         		+ "(id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(100), data DATE"
	        	)
	    	){
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
