package com.abelem.tdd.service;

import java.util.List;

import com.abelem.tdd.email.NotificadorEmail;
import com.abelem.tdd.model.Pedido;
import com.abelem.tdd.model.StatusPedido;
import com.abelem.tdd.repository.Pedidos;
import com.abelem.tdd.sms.NotificadorSms;

public class PedidoService {
	
	private Pedidos pedidos;	
	List<AcaoLancamentoPedido> acoes;
	
	public PedidoService(Pedidos pedidos, List<AcaoLancamentoPedido> acoes) {
		super();
		this.pedidos = pedidos;
		this.acoes = acoes;
	}
	
	public double lancar(Pedido pedido) {
		double imposto = pedido.getValor() * 0.1;
		
		pedidos.guardar(pedido);
		
//		for (AcaoLancamentoPedido acao : acoes) {
//			acao.executar(pedido);
//		}
		//using java8 lambda
		acoes.forEach(a -> a.executar(pedido));
		
		return imposto;
	}

	public Pedido pagar(Long codigoPedido) {
		Pedido pedido = pedidos.buscarPeloCodigo(codigoPedido);
		
		if (!pedido.getStatus().equals(StatusPedido.PENDENTE))
			throw new StatusPedidoInvalidoException();
		
		pedido.setStatus(StatusPedido.PAGO);
		return pedido;
	}

}
