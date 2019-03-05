package com.abelem.tdd.repository;

import com.abelem.tdd.model.Pedido;

public class Pedidos {
	public void guardar(Pedido pedido) {
		System.out.println("Salvando no banco de dados...");
	}
	
	public Pedido buscarPeloCodigo(Long codigo) {
		// ele iria ao db.. mas como nao tem, vamos simular
		return new Pedido();
	}
}
