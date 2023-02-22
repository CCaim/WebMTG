package main.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ncards")
public class Carta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "Nname")
	private String Nname;
	@Column(name = "Nset")
	private String Nset;

	@ManyToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "decks_cartas", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "id_deck") })
	@JsonIgnore
	private Set<Deck> decks;
	
	public Carta() {
		
	}
	
	public Carta(int id, String nname, String nset, Set<Deck> decks) {
		super();
		this.id = id;
		Nname = nname;
		Nset = nset;
		this.decks = decks;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNname() {
		return Nname;
	}

	public void setNname(String nname) {
		Nname = nname;
	}

	public String getNset() {
		return Nset;
	}

	public void setNset(String nset) {
		Nset = nset;
	}

	public Set<Deck> getDecks() {
		return decks;
	}

	public void setDecks(Set<Deck> decks) {
		this.decks = decks;
	}

	@Override
	public String toString() {
		return "Nombre: " + Nname + "\n";
	}

}
