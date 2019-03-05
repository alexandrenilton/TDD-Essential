package com.abelem.tdd.sms;

import com.abelem.tdd.model.Pedido;
import com.abelem.tdd.service.AcaoLancamentoPedido;

public class NotificadorSms implements AcaoLancamentoPedido {

	public void executar(Pedido pedido) {
		System.out.println("Enviando o sms...");
	}
}
