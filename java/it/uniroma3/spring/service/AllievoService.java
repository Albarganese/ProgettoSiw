package it.uniroma3.spring.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Allievo;
import it.uniroma3.spring.repository.AllievoRepository;

@Service
public class AllievoService {

	@Autowired
	private AllievoRepository allievoRepository; 

	@Transactional
	public void addAllievo(final Allievo allievo) {
		this.allievoRepository.save(allievo);
	}
	
	@Transactional
	public void delete(Long id){
		this.allievoRepository.delete(id);
	}
	@Transactional
	public void removeAllievo(Allievo allievo){
		this.allievoRepository.delete(allievo);
	}
	
	public Iterable<Allievo> findAll() {
		return this.allievoRepository.findAll();
	}
	public Allievo findbyId(Long id) {
		return this.allievoRepository.findOne(id);
	}
	
	public Iterable<Allievo>findByNome(String titolo) {
		return this.allievoRepository.findByNome(titolo);
	}
	
	public Iterable<Allievo>findByCognome(String cognome) {
		return this.allievoRepository.findByCognome(cognome);
	}
	
	public Iterable<Allievo>findByDataNascita(Date dataNascita) {
		return this.allievoRepository.findByDataNascita(dataNascita);
	}

}