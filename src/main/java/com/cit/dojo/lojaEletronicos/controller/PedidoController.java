package com.cit.dojo.lojaEletronicos.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cit.dojo.lojaEletronicos.entity.Pedido;
import com.cit.dojo.lojaEletronicos.service.PedidoService;

@Component
public class PedidoController implements Serializable {

	/**
	 * Serial gerado.
	 */
	private static final long serialVersionUID = -3049691963243626511L;

	@Autowired
	private transient PedidoService pedidoService;

	private Pedido pedido = new Pedido();

	public String salvar() {

		try {
			pedidoService.salvarPedido(pedido);

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso Pedido", null));

			// return "sistema/home?faces-redirect=true";

			return null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro Pedido", null));
			return "";
		}
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}