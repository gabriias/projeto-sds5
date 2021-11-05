package com.devsuperior.dsvendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.services.SaleService;

//indica q a classe será um controlador rest
@RestController
//indica o caminho do recurso web
@RequestMapping(value = "/sales")
public class SaleController {
	
	//essa anotação faz a instância do SaleService automaticamente sem precisar do 'new'
	@Autowired
	private SaleService service;
	
	//endpoint
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
		
	}

}
