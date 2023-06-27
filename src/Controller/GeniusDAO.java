package Controller;

import Model.Campeonato;
import Model.Jogador;

public interface GeniusDAO {

	
	public void addJogador(Jogador jogador) throws Exception;
	public Jogador buscarJogador(String nome)throws Exception;
	public void addCampeonato(Campeonato campeonato)throws Exception;
	public void buscarCampeonato(String nome)throws Exception;
	public void initAgenda()throws Exception;
	
	
}
