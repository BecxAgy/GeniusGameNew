//package Controller;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import javax.swing.JOptionPane;
//
//import Model.Campeonato;
//import Model.Jogador;
//
//public class SqLiteGeniusDAO  implements GeniusDAO{
//
//	  private Connection conn;
//	  ConexaoBD conexao = new ConexaoBD();
//	 
//	    // Resto do código da classe omitido
//
//	    public void inserirJogador(Jogador jogador) {
//	        try {
//	            conn = conexao.conectaBD();
//
//	            String sql = "INSERT INTO Jogadores (ID, NOME , APELIDO, PONTUACAO)"
//	            		+ "VALUES (?, ? , ? , ?)";
//	            PreparedStatement stmt = conn.prepareStatement(sql);
//	            stmt.setInt(1, jogador.getId());
//	            stmt.setString(2, jogador.getNome());
//	            stmt.setString(3,jogador.getApelido());
//	            stmt.setInt(4, jogador.getPontuacaoTotal());
//	       
//	            stmt.executeUpdate();
//
//	            JOptionPane.showMessageDialog(null, "Jogador inserido com sucesso!");
//	        } catch (SQLException e) {
//	            JOptionPane.showMessageDialog(null, "Erro ao inserir jogador: " + e.getMessage());
//	        } finally {
//	            conexao.fecharConexao();   
//	        }	
//	        
//	    }
//	        
//	        @Override
//	public Jogador buscarJogador(String nome) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void addCampeonato(Campeonato campeonato) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void buscarCampeonato(String nome) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void initAgenda() throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void addJogador(Jogador jogador) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	
//	
//}
