package it.uniroma3.spring.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Allievo;
import it.uniroma3.spring.model.Attivita;
import it.uniroma3.spring.repository.AttivitaRepository;

@Service
public class AttivitaService {
    
	@Autowired
    
	EntityManager em;
    
    @Autowired
    private AttivitaRepository attivitaRepository; 
 

    public Iterable<Attivita> findAll() {
        return this.attivitaRepository.findAll();
    }
    @Transactional
	public void delete(Long id){
		this.attivitaRepository.delete(id);
	}
    
	public Attivita save(Attivita entity) {
		if (!em.contains(entity)) {
			em.persist(entity);
			return entity;
		} else {
			return em.merge(entity);
		}
	}
    
    @Transactional
    public void add(final Attivita attivita) {
        this.attivitaRepository.save(attivita);
    }

	public Attivita findbyId(Long id) {
		return this.attivitaRepository.findOne(id);
	}
	public List<Attivita> findByAllievo(Allievo allievo){
		return this.attivitaRepository.findByAllievo(allievo);
	}
	
}
