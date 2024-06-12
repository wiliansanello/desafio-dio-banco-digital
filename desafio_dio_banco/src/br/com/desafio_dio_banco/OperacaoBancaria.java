package br.com.desafio_dio_banco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
public @Data class OperacaoBancaria {
	
	private @Getter String descricao;
	private @Getter String movimentacao;
	private @Getter double valor;
	
	@Override
	public String toString() {
		return "Descrição: " + descricao + "\n" 
				+ "Movimentação: " + movimentacao + "\n"
				+ "Valor: $ " + valor + "\n\n";
	}
	
	

}
