package it.uniroma3.spring.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Attivita implements Comparable<Attivita> {

protected Attivita() {}
	
	public Attivita(String nome,Centro centro, Date dataAttivita) {
		this.nome = nome;
	
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=1)
	private String nome;

	@NotNull
	@Column(nullable=false)
    private Date dataAttivita;
	
	@ManyToOne
	private Centro centro;
	
	@ManyToMany
	private List<Allievo> allievo;

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

	public List<Allievo> getAllievo() {
		return allievo;
	}

	public void setAllievo(List<Allievo> allievo) {
		this.allievo = allievo;
	}

	public Date getDataAttivita() {
		return dataAttivita;
	}

	public Centro getStanza() {
		return centro;
	}

	public void setStanza(Centro centro) {
		this.centro = centro;
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


	public Date getdataAttivita() {
		return dataAttivita;
	}

	public void setDataAttivita(Date dataAttivita) {
		this.dataAttivita = dataAttivita;
	}
	

	@Override
	public String toString() {
		return String.format(
				"Opera[id=%d, nome='%s', anno=%d]",
				id, nome, dataAttivita);
	}
	@Override
	public int compareTo(Attivita that) {
		return this.nome.toUpperCase().compareTo(that.nome.toUpperCase());
	}
}