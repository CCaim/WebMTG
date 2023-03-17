package main.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.crud.RolRepo;
import main.model.Rol;
import main.servicio.interfaces.RolService;

@Service
public class RolServiceImplements implements RolService {

	@Autowired
	private RolRepo rolRepo;

	@Override
	public Rol findByNombre(String nombre) {
		
	return rolRepo.findByNombre(nombre);
	}

	@Override
	public Rol insertarRol(Rol rol) { 
	return rolRepo.save(rol);
	}
}
