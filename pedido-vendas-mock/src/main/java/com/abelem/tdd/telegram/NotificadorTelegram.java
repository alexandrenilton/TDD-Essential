package com.abelem.tdd.telegram;

import com.abelem.tdd.model.Pedido;
import com.abelem.tdd.service.AcaoLancamentoPedido;

public class NotificadorTelegram implements AcaoLancamentoPedido{

	@Override
	public void executar(Pedido pedido) {
		System.out.println("Notificar telegram");
	}

}
