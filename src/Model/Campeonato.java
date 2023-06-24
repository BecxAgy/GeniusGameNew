package Model;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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




	public void iniciarCampeonato() {
        Rodada rodadaAtual;

        	//como vou alternar os jogadores...
        	rodadaAtual = jogadores.get(0).criaNovaRodada();       	
        	rodadaAtual.iniciarRodada(this.getDificuldade());   	

    }
	
	public void continuarCampeonato(int indexJodador) {
		 Rodada rodadaAtual;

     	//como vou alternar os jogadores...
     	rodadaAtual = jogadores.get(indexJodador).criaNovaRodada();
     	
     	rodadaAtual.iniciarRodada(this.getDificuldade());
	}

    public Jogador passaVez(Jogador jogadorAnterior) {
    	//qual index meu usuario esta 
    	int posicao = jogadores.indexOf(jogadorAnterior) + 1; 
    	//qual tamanho da minha lista
    	int qtdJogadores = jogadores.size(); 
    	 
    	if(posicao == qtdJogadores) {
    		//acabou o jogo
    		JOptionPane.showMessageDialog(null,"SE FODEU" ,"errou",0);
    		
    	}
    	JOptionPane.showMessageDialog(null,"passando a vez... " + jogadores.get(posicao).getApelido() ,"errou",0);
    	this.continuarCampeonato(posicao);
    	return jogadores.get(posicao);
    }

    // Método para verificar se houve empate
    private void verificarEmpate() {
        // Implemente a lógica para verificar se há empate entre os jogadores
        // Atualize a variável "empatado" de acordo
    }

    // Método para imprimir o relatório final
    private void imprimirRelatorio() {
        
    }
	
    public void continuarCampeonatoComMesmoJogador(Jogador jogador) {
    	  Rodada rodadaAtual;

      	//como vou alternar os jogadores...
      	rodadaAtual = jogador.criaNovaRodada();  
      	
      	rodadaAtual.iniciarRodada(this.getDificuldade());   	

		
	}

	
	
	

}


