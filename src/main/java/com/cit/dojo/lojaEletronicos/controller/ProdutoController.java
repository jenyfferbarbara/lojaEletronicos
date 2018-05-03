package com.cit.dojo.lojaEletronicos.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cit.dojo.lojaEletronicos.entity.Produto;
import com.cit.dojo.lojaEletronicos.service.BusinessException;
import com.cit.dojo.lojaEletronicos.service.ProdutoService;
import com.cit.dojo.lojaEletronicos.service.UsuarioService;

@Component
public class ProdutoController implements Serializable {

	/**
	 * Serial gerado.
	 */
	private static final long serialVersionUID = 5287367500405194326L;

	@Autowired
	private transient ProdutoService produtoService;

	@Autowired
	private transient UsuarioService usuarioService;
	
	private Produto produto = new Produto();

	public String salvar() {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			usuarioService.validarUsuarioLogado((String) facesContext.getExternalContext().getSessionMap().get("usuarioAutenticado"));
			
			produtoService.salvarProduto(produto);
		} catch (BusinessException be) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, be.getMessage(), null));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao cadastrar o Produto.", null));
		}
		
		if(FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro Produto efetuado com Sucesso.", null));
		}
		
		return "";
	}

	public String cancelar() {
		return "home?faces-redirect=true";
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}