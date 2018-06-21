package it.uniroma3.spring.model;

import java.util.List;

import javax.persistence.*;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Centro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=1)
	private String nome;
	
	@NotNull
	@Size(min=1)
	private String indirizzo;
	
	@NotNull
	@Size(min=1)
	private String email;

    
	@NotNull
	private Integer capienza;
	

	@OneToMany(mappedBy="centro", cascade=CascadeType.ALL)
	private List<Attivita> attivitas;
	
	
	public Integer getCapienza() {
		return capienza;
	}


	public void setCapienza(Integer capienza) {
		this.capienza = capienza;
	}

    public String getIndirizzo() {
		return indirizzo;
	}


	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public List<Attivita> getAttivitas() {
		return attivitas;
	}


	public void setAttivitas (List<Attivita> attivitas) {
		this.attivitas = attivitas;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

}