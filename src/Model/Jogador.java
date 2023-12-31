package Model;

import java.util.ArrayList;
import java.util.UUID;

public class Jogador {
	private int id;
	private String nome;
	private String apelido;
	private ArrayList<Rodada> rodadas;
	private int pontuacaoTotal;
	private int tempoJogado;
	
	public Jogador(String nome, String apelido) {
		
		this.setNome(nome);
		this.apelido = apelido;
		this.setPontuacaoTotal(0);
		this.setTempoJogado(0);
		rodadas = new ArrayList<Rodada>();
			
	}

	public int getPontuacaoTotal() {
		return pontuacaoTotal;
	}

	public void setPontuacaoTotal(int pontuacaoTotal) {
		this.pontuacaoTotal += pontuacaoTotal;
	}
	
	public ArrayList<Rodada> getListaRodadas(){
		return this.rodadas;
	}
	
	
	public Rodada getRodadaAtual() {
		
		return rodadas.get(rodadas.size() - 1);
	}
	
	//alterar para cria
	public Rodada criaNovaRodada() {
		Rodada novaRodada = new Rodada();
		
		getSequencia(novaRodada);
		
		rodadas.add(novaRodada);
		
		return novaRodada;
	}
	

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public void getSequencia(Rodada novaRodada){
    	if(rodadas.size() >= 1) {
			//pegar a sequencia antiga e formar uma nova sequencia com mais um
			novaRodada.setSequencia(rodadas.get(rodadas.size() - 1).geraSequencia());
		}else {
			novaRodada.geraSequencia();
		}
    
	}

	
	public void continuaRodadas() {
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTempoJogado() {
		return tempoJogado;
	}

	public void setTempoJogado(int tempoJogado) {
		this.tempoJogado = tempoJogado;
	}



}

