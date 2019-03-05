package com.abelem;

import com.abelem.desconto.CalculadoraDesconto1Faixa;
import com.abelem.desconto.CalculadoraDesconto2Faixa;
import com.abelem.desconto.CalculadoraDesconto3Faixa;
import com.abelem.desconto.CalculadoraFaixaDesconto;
import com.abelem.desconto.SemDesconto;

public class PedidoBuilder {

	private Pedido instancia;

	public PedidoBuilder() {
		super();
		CalculadoraFaixaDesconto calculadoraFaixaDesconto = 
				new CalculadoraDesconto3Faixa(
						new CalculadoraDesconto2Faixa(
								new CalculadoraDesconto1Faixa(
										new SemDesconto(null))));

		instancia = new Pedido(calculadoraFaixaDesconto);
	}
	
	public PedidoBuilder comItem(double valorUnitario, int quantidade) {
		
		instancia.adicionarItem(new ItemPedido("Gerado", valorUnitario, quantidade));
		return this;
	}

	public Pedido construir() {
		return instancia;
	}

}
