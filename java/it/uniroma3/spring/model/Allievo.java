package it.uniroma3.spring.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Allievo {
	
public Allievo() {}
	
	public Allievo(String nome, String cognome,String email, String luogoNascita, Date dataNascita) {
		this.nome = nome;
		this.cognome =cognome;
		this.email = email;
		this.luogoNascita = luogoNascita;
		this.dataNascita = dataNascita;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=1)
	private String nome;

	@NotNull
	@Size(min=1)
	private String cognome;
	
	private String email;
	
	private String luogoNascita;


	@NotNull
	@Column(nullable=false)
	private Date dataNascita;

	@ManyToMany(mappedBy="allievo",cascade=CascadeType.ALL)
	private List<Attivita> attivitas;


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
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public List<Attivita> getAttivitas() {
		return attivitas;
	}	
	
	public void setAttivitas(List<Attivita> attivitas) {
		this.attivitas = attivitas;
	}

	@Override
	public String toString() {
		return "" + id + " " + nome + " " + cognome;
	}


}
