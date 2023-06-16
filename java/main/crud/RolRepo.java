package main.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import main.model.Rol;


public interface RolRepo extends JpaRepository<Rol, Integer>{

	public Rol findByNombre(String nombre);

}
