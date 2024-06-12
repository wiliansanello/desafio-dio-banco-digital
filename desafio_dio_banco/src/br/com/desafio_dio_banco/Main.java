package br.com.desafio_dio_banco;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private static List<Conta> contas = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Cliente joaquim = new Cliente();
		joaquim.setNome("Joaquim");
		
		Conta ccJoaquim = new ContaCorrente(joaquim);
		
		ccJoaquim.depositar(100);
		ccJoaquim.sacar(200);
		
		Conta poupancaJoaquim = new ContaPoupanca(joaquim);
		
		ccJoaquim.transferir(110, poupancaJoaquim);
		ccJoaquim.imprimirExtrato();
		poupancaJoaquim.imprimirExtrato();
		
		Cliente bernardo = new Cliente();
		bernardo.setNome("Bernardo");
		
		Conta ccBernardo = new ContaCorrente(bernardo);
						
		Banco banco = new Banco();
		banco.setNome("Iglubank");
		
		contas.add(ccJoaquim);
		contas.add(poupancaJoaquim);
		contas.add(ccBernardo);
		
		banco.listarContas(contas);
	}

}
