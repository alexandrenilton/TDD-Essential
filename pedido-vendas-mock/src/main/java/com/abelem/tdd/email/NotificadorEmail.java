package com.abelem.tdd.email;

import com.abelem.tdd.model.Pedido;
import com.abelem.tdd.service.AcaoLancamentoPedido;

public class NotificadorEmail implements AcaoLancamentoPedido {
	
	public void executar(Pedido pedido) {
		System.out.println("Enviando o email...");
	}
}
