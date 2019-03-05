package com.abelem;

public class ItemPedido {
	public String item;
	public double valorUnidade;
	public int qtdUnidades;

	public ItemPedido(String item, double valorUnidade, int qtdUnidades) {
		this.item = item;
		this.valorUnidade = valorUnidade;
		this.qtdUnidades = qtdUnidades;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getValorUnidade() {
		return valorUnidade;
	}

	public void setValorUnidade(double valorUnidade) {
		this.valorUnidade = valorUnidade;
	}

	public int getQtdUnidades() {
		return qtdUnidades;
	}

	public void setQtdUnidades(int qtdUnidades) {
		this.qtdUnidades = qtdUnidades;
	}
	
	
}