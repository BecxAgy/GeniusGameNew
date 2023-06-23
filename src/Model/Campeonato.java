package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Campeonato {
	
	private String nome;
	private LocalDate data;
	private ArrayList<Jogador> jogadores;
	private int dificuldade; 
	private boolean empatado;
	
	
	public Campeonato(String nome,int dificuldade) {
		this.nome = nome;
		this.dificuldade = dificuldade;
		this.empatado = false;
		this.jogadores = new ArrayList <Jogador>();
		this.data = LocalDate.now();
				
	}
	public int getDificuldade() {
		if(this.dificuldade == 1) {
			return 1000;
		}
		else if(this.dificuldade ==2) {
			return 600;
		}
		return 300;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	
	
	public Jogador getPlayer1() {
		return jogadores.get(0);
	}
	public Jogador getPlayer2() {
		return jogadores.get(1);
	}
	public Jogador getPlayer3() {
		if(jogadores.size() == 3) return jogadores.get(2);
		
		return null;
	}


	public void iniciarCampeonato() {
        Rodada rodadaAtual;
        

        	
        	rodadaAtual = jogadores.get(1).getNovaRodada();
        	
        	rodadaAtual.iniciarRodada(this.getDificuldade());
        	
        	System.out.println("proximo jogador!");
        	
        	
        

    }

    

    // Método para verificar se houve empate
    private void verificarEmpate() {
        // Implemente a lógica para verificar se há empate entre os jogadores
        // Atualize a variável "empatado" de acordo
    }

    

    // Método para imprimir o relatório final
    private void imprimirRelatorio() {
        
    }
	
	

}


