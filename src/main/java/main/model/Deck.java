package main.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "decks")
public class Deck {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nombre_deck")
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	@JsonIgnore
	private Usuario usuario;

	 @OneToMany(mappedBy = "deck", cascade = CascadeType.ALL, orphanRemoval = true)
	    private Set<CartasDecks> cartasDecks = new HashSet<>();


	public Deck() {
		
	}

	public Deck(Integer id, String nombre, Usuario usuario, Set<CartasDecks> cartasdecks) {
		
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.cartasDecks = cartasdecks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<CartasDecks> getCartas() {
		return cartasDecks;
	}

	public void setCartas(Set<CartasDecks> cartasdecks) {
		this.cartasDecks = cartasdecks;
	}

	@Override
	public String toString() {
		return "Deck [id=" + id + ", nombre=" + nombre + ", usuario=" + usuario + ", cartas=" + cartasDecks + "]";
	}

	

}
