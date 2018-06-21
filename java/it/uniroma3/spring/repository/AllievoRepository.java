package it.uniroma3.spring.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Allievo;



public interface AllievoRepository extends CrudRepository<Allievo, Long> {

	List<Allievo> findAll();
	
    List<Allievo> findByNome(String nome);
    
    List<Allievo> findByCognome(String cognome);
        
    List<Allievo> findByDataNascita(Date dataNascita);
     
}
