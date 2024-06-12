package br.com.desafio_dio_banco;

public interface IConta {
	
	void sacar(double valor);
	
	void sacar(double valor, boolean eTransferencia);
	
	void depositar(double valor);
	
	void depositar(double valor, boolean eTransferencia);
	
	void transferir(double valor, Conta contaDestino);	
	
	void imprimirExtrato();

}
