package com.abelem.tdd.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.abelem.tdd.email.NotificadorEmail;
import com.abelem.tdd.model.Cliente;
import com.abelem.tdd.model.Pedido;
import com.abelem.tdd.model.StatusPedido;
import com.abelem.tdd.model.builder.PedidoBuilder;
import com.abelem.tdd.repository.Pedidos;
import com.abelem.tdd.sms.NotificadorSms;
import com.abelem.tdd.telegram.NotificadorTelegram;


public class PedidoServiceTest {
	
	private PedidoService pedidoService;
	
	@Mock
	private Pedidos pedidos;
	
	@Mock
	private NotificadorEmail notificadorEmail;
	
	@Mock
	private NotificadorSms notificadorSms;
	
	@Mock
	private NotificadorTelegram notificadorTelegram;
	
	private Pedido pedido;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		List<AcaoLancamentoPedido> acoes = Arrays.asList(notificadorEmail, notificadorSms, notificadorTelegram);
		pedidoService = new PedidoService(pedidos, acoes);
		
		pedido = new PedidoBuilder()
				.comValor(100.0)
				.para("John Mayer", "mayer@mayer.com", "9999-0000")
				.construir();	
	}
	
	@Test
	public void deveCalcularOImposto() throws Exception {
		double imposto = pedidoService.lancar(pedido);
		assertEquals(10.0, imposto, 0.0001);
	}
	

	@Test
	public void deveSalvarPedidoNoBancoDeDados() throws Exception {
		pedidoService.lancar(pedido);
		Mockito.verify(pedidos).guardar(pedido); /** verifica se Pedidos.guardar(pedido) foi invocado! */
	}
	
	@Test
	public void deveNotificarPorEmail() throws Exception {
		pedidoService.lancar(pedido);
		Mockito.verify(notificadorEmail).executar(pedido);
	}
	
	@Test
	public void deveNotificarPorSms() throws Exception {
		pedidoService.lancar(pedido);
		Mockito.verify(notificadorSms).executar(pedido);
	}
	
	@Test
	public void deveNotificarPorTelegram() throws Exception {
		pedidoService.lancar(pedido);
		Mockito.verify(notificadorTelegram).executar(pedido);
	}
	
	@Test
	public void devePagarPedidoPendente() throws Exception {
		Long codigoPedido = 135L;
		
		/*Quando o metodo buscarPeloCodigo for invocado, vai retornar o getPedidoPendente() */
		Mockito.when(pedidos.buscarPeloCodigo(codigoPedido))
			.thenReturn(getPedidoPendente());
		
		Pedido pedigoPago = pedidoService.pagar(codigoPedido);
		
		assertEquals(StatusPedido.PAGO, pedigoPago.getStatus());
	}
	
	@Test (expected = StatusPedidoInvalidoException.class)
	public void deveNegarPagamento() throws Exception {
		Long codigoPedido = 135L;
		
		Pedido pedidoPendente = getPedidoPendente();
		pedidoPendente.setStatus(StatusPedido.PAGO);
		
		Mockito.when(pedidos.buscarPeloCodigo(codigoPedido))
			.thenReturn(pedidoPendente);
		
		/* roda ok se a exception StatusPedidoInvalidoException for lançada durante a execucao RuntimeException */
		Pedido pedigoPago = pedidoService.pagar(codigoPedido);
	}
	
	
	private Pedido getPedidoPendente() {
		Pedido pedido = new Pedido();
		pedido.setStatus(StatusPedido.PENDENTE);
		pedido.setCliente(new Cliente("Alexandre", "alexandrenilton@gmail.com", "61 999672643") );
		return pedido;
	}

}
