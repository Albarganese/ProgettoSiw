package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Centro;


public interface CentroRepository extends CrudRepository<Centro, Long> {

	List<Centro> findAll();
	
    List<Centro> findByNome(String nome);
    
    List<Centro> findByIndirizzo(String indirizzo);
    
 
}
