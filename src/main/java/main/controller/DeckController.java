package main.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import main.crud.CartaRepo;
import main.crud.DeckRepo;
import main.crud.UsuarioRepo;
import main.model.Carta;
import main.model.Deck;
import main.model.Usuario;
import main.servicio.impl.CartaServiceImplements;
import main.servicio.impl.DeckServiceImplements;
import main.servicio.impl.UsuarioServiceImplements;

@RequestMapping("/decks")
@Controller
public class DeckController {

	@Autowired
	private DeckServiceImplements deckSI;

	@Autowired
	private UsuarioServiceImplements usuarioSI;

	@Autowired
	private CartaServiceImplements cartaSI;

	@GetMapping(value = { "", "/" })
	String homeDecks(Model model) {

		// Salir a buscar a la BBDD
		ArrayList<Deck> misDecks = (ArrayList<Deck>) deckSI.listarDeck();
		ArrayList<Usuario> misUsuarios = (ArrayList<Usuario>) usuarioSI.listarUsuario();
		ArrayList<Carta> misCartas = (ArrayList<Carta>) cartaSI.listarCarta();

		model.addAttribute("listarCartas", misCartas);
		model.addAttribute("listarUsuarios", misUsuarios);
		model.addAttribute("listarDecks", misDecks);

		model.addAttribute("deckEditar", new Deck());
		model.addAttribute("deckNuevo", new Deck());
		return "decks";

	}

	@PostMapping("/edit/{id}")
	public String editarDeck(@PathVariable Integer id, @ModelAttribute("deckEditar") Deck deckEditado,
			BindingResult bindingresult) {

		Usuario user = usuarioSI.obtenerUsuarioPorId(id);
		deckEditado.setUsuario(user);

		Deck deckEditar = deckSI.obtenerDeckPorId(id);
		for (Carta card : deckEditar.getCartas()) {
			if (!deckEditado.getCartas().contains(card)) {
				card.getDecks().remove(deckEditado);
			}
		}
		for (Carta card : deckEditar.getCartas()) {
			if (!deckEditado.getCartas().contains(card)) {
				card.getDecks().add(deckEditar);
			}
		}
		deckSI.insertarDeck(deckEditado);
		return "redirect:/decks";
	}
	@GetMapping("/delete/{id}")
	String deleteDeck(Model model, @PathVariable Integer id) {
		
		deckSI.elimminarDeckPorId(id);
		return "redirect:/decks";
	}
	@PostMapping("/addncard")
	public String editarDeck(@ModelAttribute("deckNuevo") Deck deckNew, BindingResult bindingresult) {
		
		Usuario newUser = usuarioSI.obtenerUsuarioPorId(deckNew.getUsuario().getId());
		
		newUser.getDecks().add(deckNew);
		deckNew.setUsuario(newUser);
		
		for(Carta card: deckNew.getCartas()) {
			card.getDecks().add(deckNew);
		}
		deckSI.insertarDeck(deckNew);
		
		return "redirect:/deck";
	}
	@GetMapping(value= "/{id}")
	String id(Model model, @PathVariable Integer id) {
		
		Deck deckMostrar = deckSI.obtenerDeckPorId(id);
		model.addAttribute("deckMostrar", deckMostrar);
		model.addAttribute("deckEditado", new Deck());
		
		ArrayList<Usuario> misUsers = (ArrayList<Usuario>) usuarioSI.listarUsuario();
		ArrayList<Carta> misCartas = (ArrayList<Carta>) cartaSI.listarCarta();
		
			
		
		model.addAttribute("listarUsuarios" ,misUsers);
		model.addAttribute("listarCartas" ,misCartas);
	
		
		return "deck";
		
	}
}
