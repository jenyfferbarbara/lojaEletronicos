package com.cit.dojo.lojaEletronicos.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cit.dojo.lojaEletronicos.entity.Produto;
import com.cit.dojo.lojaEletronicos.service.ProdutoService;

@Component
public class ProdutoController implements Serializable {

	/**
	 * Serial gerado.
	 */
	private static final long serialVersionUID = 5287367500405194326L;

	@Autowired
	private transient ProdutoService produtoService;

	private Produto produto = new Produto();

	public String salvar() {

		try {
			produtoService.salvarProduto(produto);

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso Produto", null));

			// return "sistema/home?faces-redirect=true";

			return null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro Produto", null));
			return "";
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}