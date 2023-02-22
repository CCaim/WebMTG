package main.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.crud.CartaRepo;
import main.model.Carta;

@Service
public class CartaServiceImplements {

	@Autowired
	private CartaRepo cartaRepo;
	
	
	public Carta insertarCarta (Carta card) {
		cartaRepo.save(card);
		return null;
	}
	
	
	public List<Carta> listarCarta(){
		return cartaRepo.findAll();
	}
	
	public Carta obtenerCartaPorNombre(String Nname) {
		return cartaRepo.findByNname(Nname).get();
	}
}
