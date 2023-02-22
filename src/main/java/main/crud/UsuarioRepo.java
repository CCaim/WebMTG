package main.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
	
	public Optional<Usuario> findByUsername(String username);
}
