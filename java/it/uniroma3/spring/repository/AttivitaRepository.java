package it.uniroma3.spring.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Allievo;
import it.uniroma3.spring.model.Attivita;

public interface AttivitaRepository extends CrudRepository<Attivita, Long> {

    List<Attivita> findByNome(String nome);
    
    List<Attivita> findByDataAttivita(Date dataAttivita);

	List<Attivita> findByAllievo(Allievo allievo);
   	
    
}