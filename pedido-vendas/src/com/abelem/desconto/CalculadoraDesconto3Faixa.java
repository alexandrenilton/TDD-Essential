package com.abelem.desconto;

public class CalculadoraDesconto3Faixa extends CalculadoraFaixaDesconto{

	public CalculadoraDesconto3Faixa(CalculadoraFaixaDesconto next) {
		super(next);
	}

	@Override
	protected double calcular(double valorTotal) {
		if (valorTotal > 1000.0) {
			return valorTotal * 0.08;
		}
		return -1;
	}
	

}
