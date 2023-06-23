package Model;

import java.util.ArrayList;
import java.util.UUID;

public class Jogada {
	private UUID id;
	private Jogador jogador;
	private int pontuacao;
	private int tempo;
	private ArrayList<Integer> sequencia;//lembrar de 
	
	
	public Jogada(Jogador jogador) {
		this.id = UUID.randomUUID();
		this.jogador = jogador;
		this.pontuacao = 0;
		this.tempo = 0;
	}
	
	// Método para calcular a pontuação do jogador
    private void calcularPontuacao() {
       jogador.setPontuacaoTotal(jogador.getPontuacaoTotal() + pontuacao);
    }

	public void addSequenciaCompleta(ArrayList<Integer> sequencia2) {
		// TODO Auto-generated method stub
		
	}
	
}
