package com.abelem.service;

import com.abelem.model.Passageiro;
import com.abelem.model.TipoPassageiro;
import com.abelem.model.Voo;

public class PrecoPassagemService {

	/**
	 * Classe com muita responsabilidade, pois ela tá calculado o preco da passagem
	 * para passageiros do tipo Gold, Silver.. X Y e Z (caso ela venha a crecer
	 * 
	 * @param passageiro
	 * @param voo
	 * @return
	 */

	public double calcular(Passageiro passageiro, Voo voo) {
		/*
		if (passageiro.getTipo().equals(TipoPassageiro.GOLD)) {
			if (voo.getPreco() > 500) {
				return voo.getPreco() * 0.85;
			}
			return voo.getPreco() * 0.9;
		} else if (passageiro.getTipo().equals(TipoPassageiro.SILVER)) {
			if (voo.getPreco() > 700) {
				return voo.getPreco() * 0.9;
			}
			return voo.getPreco() * 0.94;
		}
		*/
		/* apos refatorar, o SRP */
		return passageiro.getTipo().getCalculadora().calcular(voo);
	}

}
