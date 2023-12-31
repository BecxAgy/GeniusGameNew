package Controller;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Campeonato;
import Model.Jogador;




public class DAOCampeonatoSqLite  implements DAOCampeonato {

	@Override
	public void addCampeonato(Campeonato campeonato) throws Exception {
		 try (Connection conn = ConexaoBD.getIntancia().getConexao();) {
	            String query = "INSERT INTO campeonato (nome, data) VALUES (?, ?)";
	            PreparedStatement statement = conn.prepareStatement(query);
	            statement.setString(1, campeonato.getNome());
	            statement.setDate(2, 	(Date) campeonato.getData());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

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
	            campeonato.setId(rs.getInt("id"));
	            campeonato.setNome(rs.getString("nome"));
	            campeonato.setData(rs.getDate("data"));
	            
	            // Obter os jogadores do campeonato atual
	            ArrayList<Jogador> jogadores = null;
				try {
					jogadores = getJogadoresByCampeonatoId(campeonatoId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            campeonato.setJogadores(jogadores);
	            
	            campeonatos.add(campeonato);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return campeonatos;
	}

	public ArrayList<Jogador> getJogadoresByCampeonatoId(int campeonatoId) throws Exception{
	   
		ArrayList<Jogador> jogadores = new ArrayList<>();
	    
	    try (Connection conn = ConexaoBD.getIntancia().getConexao();
	         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM jogadores WHERE campeonato_id = " + campeonatoId);
	         
	         ResultSet rs = stmt.executeQuery()) {
	        
	        while (rs.next()) {
	            Jogador jogador = new Jogador(null,null);
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
