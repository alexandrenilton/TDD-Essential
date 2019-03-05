package com.abelem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.abelem.desconto.CalculadoraDesconto1Faixa;
import com.abelem.desconto.CalculadoraDesconto2Faixa;
import com.abelem.desconto.CalculadoraDesconto3Faixa;
import com.abelem.desconto.CalculadoraFaixaDesconto;
import com.abelem.desconto.SemDesconto;

public class PedidoTest {
	
	private PedidoBuilder pedido;
	
	@Before
	public void setup() {
		pedido = new PedidoBuilder();
	}
	
	private void assertResumoPedido(double valorTotal, double desconto) {
		ResumoPedido resumoPedido = pedido.construir().resumo();
		assertEquals(new ResumoPedido(valorTotal, desconto), resumoPedido);
	}

	@Test
	public void devePermitirAdionarUmItemNoPedido() throws Exception {
		pedido.comItem(2.98, 20);
		assertResumoPedido(59.6, 0.0);
	}
	
	@Test 
	public void deveCalcularValorTotalEDescontoParaPedidoVazio() throws Exception {
		assertResumoPedido(0.0, 0.0);
	}

	@Test
	public void deveCalcularResumoParaItemSemDesconto() throws Exception {
		pedido.comItem(5.0, 5);
		assertResumoPedido(25.0, 0.0);
	}
	
	@Test
	public void deveCalcularOResumoParaDoisItensSemDesconto() throws Exception {
		pedido.comItem(3.0, 3)
				.comItem(7.0,  3);
		
		assertResumoPedido(30.0, 0.0);
	}
	
	@Test
	public void deveAplicarDescontoNa1Faixa() throws Exception {
		pedido.comItem(20.0, 20);
		assertResumoPedido(400.0, 16.0);
	}
	
	@Test
	public void deveAplicarDescontoNa2Faixa() throws Exception {
		pedido.comItem(15, 30)
			.comItem(15, 30);
		assertResumoPedido(900.00, 54.00);
	}
	
	@Test
	public void deveAplicarDescontoNa3Faixa() throws Exception {
		pedido.comItem(15, 30)
			.comItem(15.0, 30)
			.comItem(10.0, 30);
		assertResumoPedido(1200.00, 96.00);
	}
	
	
	@Test(expected = QuantidadeItensInvalidoException.class)
	public void naoAceitarPedidosComItensComQuantidadesNegativas() throws Exception {
		pedido.comItem(15.0, -10);
		
		//add no adicionarItem a verificação de exceção
	}
	
	
	/*
	 * @Test public void naoAceitarPedidosComItensComQuantidadesNegativas() throws
	 * Exception { try { pedido.comItem(15.0, -10);
	 * fail("Deveria ter lançado a exception QuantidadeItensInvalidaException"); }
	 * catch( QuantidadeItensInvalidoException qiiex) { String message =
	 * qiiex.getMessage(); assertEquals("Não pode ser negativo", message); } }
	 */
}
