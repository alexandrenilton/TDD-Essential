package com.abelem.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.abelem.model.Passageiro;
import com.abelem.model.TipoPassageiro;
import com.abelem.model.Voo;

public class PrecoPassagemServiceTest {
	
	private PrecoPassagemService precoPassagemService;
	
	@Before
	public void setup() {
		precoPassagemService = new PrecoPassagemService();
	}
	
	private void assertValorPassagem(Passageiro passageiro, Voo voo, double esperado) {
		double valor = precoPassagemService.calcular(passageiro, voo);
		assertEquals(esperado, valor, 0.0001);
	}
	
	@Test
	public void deveCriarPrecoPassagemService() throws Exception {
		PrecoPassagemService precoPassagemService = new PrecoPassagemService();
	}
	
	
	@Test
	public void devePermitirChamarCalculoDoValor() throws Exception {
		Passageiro passageiro = new Passageiro("Alexandre Mayer", TipoPassageiro.GOLD);
		Voo voo = new Voo("Brasília", "Montréal", 2800.34);
		double valor = precoPassagemService.calcular(passageiro, voo);
	}
	
	@Test
	public void deveCalcularValorPassagemParaPassageiroGold_ComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Alexandre Mayer", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
		assertValorPassagem(passageiro, voo, 90.00);
	}

	
	@Test
	public void deveCalcularValorPAssagemParaPassageiroGold_ComValorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Alexandre Mayer", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Montréal", 600.0);
		assertValorPassagem(passageiro, voo, 510.0);
	}
	
	@Test
	public void deveCalcularValorPassagemParaPassageirosSilver_ComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Alexandre Mayer", TipoPassageiro.SILVER);
		Voo voo = new Voo("Rio de Janeiro", "São Paulo", 100.0);
		assertValorPassagem(passageiro, voo, 94.0);
	}
	
	@Test
	public void deveCalcularValorPassagemParaPassageirosSilver_ComValorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Alexandre Mayer", TipoPassageiro.SILVER);
		Voo voo = new Voo("Rio de Janeiro", "São Paulo", 800.0);
		assertValorPassagem(passageiro, voo, 720.0);
	}
	
	
}
