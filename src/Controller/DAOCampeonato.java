package Controller;

import java.util.ArrayList;

import Model.Campeonato;
import Model.Jogador;

public interface DAOCampeonato  {

	
		
		public void addCampeonato(Campeonato campeonato) throws Exception;
		public ArrayList<Campeonato> getAllCampeonatos()throws Exception;
		public ArrayList<Jogador> getJogadoresByCampeonatoId(int campeonatoId)throws Exception;
		public void initCampeonato()throws Exception;
		
		

	
}
