package com.vemser.tests.pojo;

import java.util.List;

public class ProdutosCadastradosResPojo{
	private List<ProdutosItem> produtos;
	private int quantidade;

	public List<ProdutosItem> getProdutos(){
		return produtos;
	}

	public int getQuantidade(){
		return quantidade;
	}

	public void setProdutos(List<ProdutosItem> produtos) {
		this.produtos = produtos;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}