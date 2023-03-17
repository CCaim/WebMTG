package main.servicio.interfaces;

import main.model.Rol;

public interface RolService {

	public Rol findByNombre(String nombre);
	
	public Rol insertarRol(Rol rol);
}
