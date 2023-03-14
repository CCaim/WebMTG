package main.servicio.interfaces;

import main.model.Rol;

public interface RolService {

	public Rol obtenerRolPorNombre(String nombre);
	
	public Rol insertarRol(Rol rol);
}
