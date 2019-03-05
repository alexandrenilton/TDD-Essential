package com.abelem.desconto;

public class CalculadoraDesconto1Faixa extends CalculadoraFaixaDesconto {

	public CalculadoraDesconto1Faixa(CalculadoraFaixaDesconto next) {
		super(next);
	}

	@Override
	protected double calcular(double valorTotal) {
		if (valorTotal > 300.0 && valorTotal <= 800.0) {
			return valorTotal * 0.04;
		}
		return -1;
	}
}