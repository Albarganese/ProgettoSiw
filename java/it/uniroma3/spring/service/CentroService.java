package it.uniroma3.spring.service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Centro;
import it.uniroma3.spring.repository.CentroRepository;


@Service
public class CentroService {

	@Autowired
	private CentroRepository centroRepository; 

	@Transactional
	public void addCentro(final Centro centro) {
		this.centroRepository.save(centro);
	}
	
	@Transactional
	public void delete(Long id){
		this.centroRepository.delete(id);
	}
	@Transactional
	public void removeCentro(Centro centro){
		this.centroRepository.delete(centro);
	}
	
	public Iterable<Centro> findAll() {
		return this.centroRepository.findAll();
	}
	public Centro findbyId(Long id) {
		return this.centroRepository.findOne(id);
	}
	
	public Iterable<Centro>findByNome(String nome) {
		return this.centroRepository.findByNome(nome);
	}
}