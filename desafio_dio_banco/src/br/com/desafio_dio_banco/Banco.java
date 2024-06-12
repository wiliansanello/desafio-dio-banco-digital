package br.com.desafio_dio_banco;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Setter;

public @Data class Banco {
	
	public @Setter String nome;
	private List<Conta> contas;
	
	public Banco() {
		this.contas = new ArrayList<>();
	}
		
	public void listarContas(List<Conta> contas) {
		System.out.println("Banco: " + nome);
		System.out.println("Agência: 1" );
		for(Conta conta : contas) {
			System.out.println(conta);
		}
	}
	
}
