package br.com.desafio_dio_banco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.AccessLevel;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract @Data class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
		
	protected int agencia;
	protected int numero;
	protected double saldo;
	private Cliente cliente;
	private List<OperacaoBancaria> extratoCliente;
	private String descricaoMovimentacao;
		
		
	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.extratoCliente = new ArrayList<>();
	}	
	
	@Override
	public void sacar(double valor) {
		descricaoMovimentacao = "saque";
		if(valor <= saldo) {
			saldo -= valor;				
			OperacaoBancaria saque = new OperacaoBancaria(descricaoMovimentacao, "débito", valor);
			extratoCliente.add(saque);
		} 
	}
	
	@Override
	public void sacar(double valor, boolean eTransferencia) {
		if (!eTransferencia) { 
			descricaoMovimentacao = "saque";
		} else {
			descricaoMovimentacao = "transferencia";			
		}
		if(valor <= saldo) {
			saldo -= valor;			
			OperacaoBancaria saque = new OperacaoBancaria(descricaoMovimentacao, "débito", valor);
			extratoCliente.add(saque);	
		} 
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;	
		descricaoMovimentacao = "deposito";
		OperacaoBancaria deposito = new OperacaoBancaria(descricaoMovimentacao, "crédito", valor);
		extratoCliente.add(deposito);
	}
	
	@Override
	public void depositar(double valor, boolean eTransferencia) {
		saldo += valor;
		if (!eTransferencia) {
			descricaoMovimentacao = "deposito";
		} else {
			descricaoMovimentacao = "transferencia";			
		}
		OperacaoBancaria deposito = new OperacaoBancaria(descricaoMovimentacao, "crédito", valor);
		extratoCliente.add(deposito);
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor, true);
		contaDestino.depositar(valor, true);
	}	
	
	public void listarMovimentacoes() {
		if(!extratoCliente.isEmpty()) {
			for(OperacaoBancaria op : extratoCliente)
				System.out.println(op);
		} else {
			System.out.println("Não há movimentações para a conta no período");
		}
	}

	protected void imprimirCabecalhoExtrato() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println("Movimentações da conta \n");
	}

	@Override
	public String toString() {
		return "Número conta: " + numero 
				+ "\n Cliente: " + cliente.getNome()
				+ "\n Saldo: " + saldo ;
	}	
	
	

}
