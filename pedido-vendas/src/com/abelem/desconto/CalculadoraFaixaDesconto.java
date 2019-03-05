package com.abelem.desconto;

public abstract class CalculadoraFaixaDesconto {
	
	private CalculadoraFaixaDesconto next;

	public CalculadoraFaixaDesconto(CalculadoraFaixaDesconto next) {
		super();
		this.next = next;
	}
	
	public double desconto(double valorTotal) {
		double desconto = calcular(valorTotal);
		
		if (desconto == -1) {
			return next.desconto(valorTotal);
		}
		
		return desconto;
	}
	
	protected abstract double calcular(double valorTotal);
	
}
