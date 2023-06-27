package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;

import Model.Campeonato;
import Model.Jogada;
import Model.Jogador;

public class GeniusGame {
	
	private ArrayList<Integer> sequencia = new ArrayList<Integer>();
	private Campeonato novoCampeonato;
	
	public GeniusGame() {
		
	}
	
	public void criarCampeonato(String nome, int dificuldade) {
		this.novoCampeonato = new Campeonato(nome, dificuldade);
	}

	public Campeonato getNovoCampeonato() {
		return this.novoCampeonato;
	}
	//pensar se isso deve estar em campeonato.
	public void criarListaJogadores(ArrayList<JTextField> dadosJogadores) {
		//adicionando jogadors na lista -- podemos encapsular no sistema
		for  (int i = 0; i<dadosJogadores.size(); i+=2) {
			Jogador novoJogador = new Jogador(dadosJogadores.get(i).getText(), dadosJogadores.get(i+1).getText());
			novoCampeonato.getJogadores().add(novoJogador);	
		}
	}
	
	public  int obterDificuldade (JRadioButton radioFacil, JRadioButton radioMedio, JRadioButton radioDificil) {
	    if (radioFacil.isSelected()) {
	        return 1;
	    } else if (radioMedio.isSelected()) {
	        return 2;
	    } 
	    
	    return 3;
	   
	}
	
	public void receberResposta(int cor, Jogador jogador) {
		//recebe cor na lista da sequencia
		sequencia.add(cor);
		
		//verifica se é a hora de pegar o jogador atual entrar na sua ultima rodada e adicionar uma nova jogada a esse jogador
		if(jogador.getListaRodadas().size() == sequencia.size()) {
			Jogada novaJogada = jogador.getRodadaAtual().criaJogada(); //fazer esse método
			
			novaJogada.addSequenciaCompleta(sequencia); //criar esse método, a lista de sequencia da jogada vai receber essa sequencia
		}
		//
	}
	
	
<<<<<<< HEAD
=======
	
>>>>>>> parent of 6c9772b (Projeto funcional)
}
