package main.servicio.interfaces;

import java.util.List;

import main.model.Carta;

public interface CartaService {

	public Carta insertarCarta (Carta card);
	
	public List<Carta> listarCarta();
	
	public Carta obtenerCartaPorNombre(String nombre);
}
