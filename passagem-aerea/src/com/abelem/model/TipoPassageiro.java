package com.abelem.model;

import com.abelem.service.CalculadoraPrecoPassagem;
import com.abelem.service.PrecoPassagemGold;
import com.abelem.service.PrecoPassagemSilver;

public enum TipoPassageiro {
	GOLD (new PrecoPassagemGold()),
	SILVER (new PrecoPassagemSilver());
	
	CalculadoraPrecoPassagem calculadoraPrecoPassagem;
	
	TipoPassageiro(CalculadoraPrecoPassagem calculadoraPrecoPassagem) {
		this.calculadoraPrecoPassagem = calculadoraPrecoPassagem;
	}
	
	public CalculadoraPrecoPassagem getCalculadora() {
		return calculadoraPrecoPassagem;
	}
}
