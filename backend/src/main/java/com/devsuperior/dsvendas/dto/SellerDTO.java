package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

/**
 * o SellerDTO vai ser um objeto com as informações da entidade pois n repassamos para o controlador uma entidade e sim, um objeto
 * a entidade é monitorada pelo banco e n precisamos disso para a camada de exibição
 */
public class SellerDTO implements Serializable {
	/**
	 * a interface Serializable permite q os objetos sejam convertidos para bytes
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public SellerDTO() {
		
	}

	public SellerDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public SellerDTO(Seller entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
