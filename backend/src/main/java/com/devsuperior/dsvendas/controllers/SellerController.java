package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.services.SellerService;

//indica q a classe será um controlador rest
@RestController
//indica o caminho do recurso web
@RequestMapping(value = "/sellers")
public class SellerController {
	
	//essa anotação faz a instância do SellerService automaticamente sem precisar do 'new'
	@Autowired
	private SellerService service;
	
	//endpoint
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll() {
		List<SellerDTO> list = service.findAll();
		return ResponseEntity.ok(list);
		
	}
	
	

}
