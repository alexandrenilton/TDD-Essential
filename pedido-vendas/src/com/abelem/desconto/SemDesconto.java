package com.abelem.desconto;

public class SemDesconto extends CalculadoraFaixaDesconto {
	public SemDesconto(CalculadoraFaixaDesconto next) {
		super(next);
	}
	
	@Override
	protected double calcular(double valorTotal) {
		return 0;
	}
}
