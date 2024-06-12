package br.com.desafio_dio_banco;

public class ContaPoupanca extends Conta{
	
	public ContaPoupanca (Cliente cliente) {
		super(cliente);
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("Extrato conta poupança");
		super.imprimirCabecalhoExtrato();
		super.listarMovimentacoes();
	}
		
}
