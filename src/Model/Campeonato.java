package Model;
import Controller.DAOCampeonatoSqLite;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Campeonato {
	private int id;
	private String nome;
	private Date data;
	private ArrayList<Jogador> jogadores;
	private int dificuldade; 
	private DAOCampeonatoSqLite  DaoCampeonato = new DAOCampeonatoSqLite ();
	
	public Campeonato() {
		
	}
	public Campeonato(String nome,int dificuldade) {
		this.nome = nome;
		this.dificuldade = dificuldade;
		
		this.jogadores = new ArrayList <Jogador>();
		this.data = Date.valueOf(LocalDate.now());
				
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

	public Date getData() {
		return data;
	}

	public void setJogadores(ArrayList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	public void setData(Date date) {
		this.data = date;
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
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	

}


