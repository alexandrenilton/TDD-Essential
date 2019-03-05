package com.abelem;

import java.util.ArrayList;
import java.util.List;

import com.abelem.desconto.CalculadoraFaixaDesconto;

public class Pedido {
	
	private double valorTotal;
	private double desconto;
	
	private List<ItemPedido> itens = new ArrayList<>();
	
	private CalculadoraFaixaDesconto calculadoraFaixaDesconto;
	
	public Pedido(CalculadoraFaixaDesconto calculadoraFaixaDesconto) {
		this.calculadoraFaixaDesconto = calculadoraFaixaDesconto;
	}
	
	public void adicionarItem(ItemPedido itemPedido) {
		validadeQuantidadeItens(itemPedido);
		itens.add(itemPedido);
	}

	/**
	 * Validade se a quantidade de unidades de um item é menor que 0
	 * @param itemPedido
	 */
	private void validadeQuantidadeItens(ItemPedido itemPedido) {
		if (itemPedido.getQtdUnidades() < 0) {
			throw new QuantidadeItensInvalidoException();
		}
	}

	
	public ResumoPedido resumo() {
		double valorTotal = itens.stream().mapToDouble(i -> i.getValorUnidade() * i.getQtdUnidades()).sum();
		double desconto = calculadoraFaixaDesconto.desconto(valorTotal);
//		double desconto = 0;
//		
//		if (valorTotal > 300.00 && valorTotal <= 800.00) {
//			desconto = valorTotal * 0.4;
//		} else if (valorTotal > 800.00  && valorTotal <= 1000.00) {
//			desconto = valorTotal * 0.06;
//		} else if (valorTotal > 1000.00) {
//			desconto = valorTotal * 0.08;
//		}
		
		return new ResumoPedido(valorTotal, desconto);
	}
	

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

}
