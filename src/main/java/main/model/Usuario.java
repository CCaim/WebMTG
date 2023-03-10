package main.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private Set<Deck> Decks;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "usuarios_roles", joinColumns = { @JoinColumn(name = "id_usuario") }, inverseJoinColumns = {
			@JoinColumn(name = "id_rol") })
	@JsonIgnore
	private Set<Rol> roles;
	public Usuario() {
		roles = new HashSet<Rol>();
	}
	public Usuario(String nombre, String username, String password) {
		this.nombre = nombre;
		this.username = username;
		this.password = password;
		roles = new HashSet<Rol>();
	}

	public Usuario(Integer id, String nombre, Set<Deck> decks, String username, String password) {
		this.id = id;
		this.nombre = nombre;
		this.username = username;
		this.password = password;
		Decks = decks;
		roles = new HashSet<Rol>();
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

	public Set<Deck> getDecks() {
		return Decks;
	}

	public void setDecks(Set<Deck> decks) {
		Decks = decks;
	}
	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	

	@Override
	public String toString() {
		String resultado = "";

		resultado += ("Usuarios [id=" + id + ", nombre=" + nombre + "]\n");
		for (Deck d : Decks) {
			resultado += d.toString();
		}
		return resultado;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
