package com.devsuperior.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

//registra a classe como um componente
@Service
public class SaleService {
	
	//essa anotação faz a instância do sellerRepository automaticamente sem precisar do 'new'
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	//garante q toda operação de banco seja feita nesse momente sem lockar o banco (readOnly = true)
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		/**
		 * salvando os vendedores em memória para evitar a busca repetidas vezes no banco MAS, isso só se aplica nesse caso
		 * pq só há 5 vendedores, caso houvessem centenas/milhares, n faria sentido essa adaptação
		 */
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	//garante q toda operação de banco seja feita nesse momente sem lockar o banco (readOnly = true)
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repository.amountGroupedBySeller();
	}
	
	//garante q toda operação de banco seja feita nesse momente sem lockar o banco (readOnly = true)
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return repository.successGroupedBySeller();
	}

}
