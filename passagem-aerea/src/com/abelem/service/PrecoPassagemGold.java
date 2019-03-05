package com.abelem.service;

import com.abelem.model.Voo;

public class PrecoPassagemGold implements CalculadoraPrecoPassagem {

	@Override
	public double calcular(Voo voo) {
		if (voo.getPreco() > 500 ) {
			return voo.getPreco() * 0.85;
		}
		return voo.getPreco() * 0.9;
	}
}
