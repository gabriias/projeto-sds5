package com.devsuperior.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

//registra a classe como um componente
@Service
public class SellerService {
	
	//essa anotação faz a instância do sellerRepository automaticamente sem precisar do 'new'
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){
		List<Seller> result = repository.findAll();
		//para cada item da lista de Seller, é criado um objeto SellerDTO e depois todos os objetos sãoa grupados numa lista de SellerDTO
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}

}
