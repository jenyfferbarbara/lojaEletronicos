package com.cit.dojo.lojaEletronicos.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cit.dojo.lojaEletronicos.entity.Pedido;
import com.cit.dojo.lojaEletronicos.service.BusinessException;
import com.cit.dojo.lojaEletronicos.service.PedidoService;
import com.cit.dojo.lojaEletronicos.service.UsuarioService;

@Component
public class PedidoController implements Serializable {

	/**
	 * Serial gerado.
	 */
	private static final long serialVersionUID = -3049691963243626511L;

	@Autowired
	private transient PedidoService pedidoService;

	@Autowired
	private transient UsuarioService usuarioService;
	
	private Pedido pedido = new Pedido();

	public String salvar() {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			usuarioService.validarUsuarioLogado((String) facesContext.getExternalContext().getSessionMap().get("usuarioAutenticado"));
			
			pedidoService.salvarPedido(pedido);

			} catch (BusinessException be) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, be.getMessage(), null));
			}catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao cadastrar o Pedido.", null));
			}
		
			if(FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro Pedido efetuado com Sucesso.", null));
			}
		
			return "";
		}

	public String cancelar() {
		return "home?faces-redirect=true";
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}