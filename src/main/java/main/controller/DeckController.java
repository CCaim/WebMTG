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

@RequestMapping("/decks")
@Controller
public class DeckController {

	@Autowired
	private DeckRepo deckRepo;

	@Autowired
	private UsuarioRepo userRepo;

	@Autowired
	private CartaRepo cartaRepo;

	@GetMapping(value = { "", "/" })
	String homeDecks(Model model) {

		// Salir a buscar a la BBDD
		ArrayList<Deck> misDecks = (ArrayList<Deck>) deckRepo.findAll();
		ArrayList<Usuario> misUsuarios = (ArrayList<Usuario>) userRepo.findAll();
		ArrayList<Carta> misCartas = (ArrayList<Carta>) cartaRepo.findAll();

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

		Usuario user = userRepo.findById(id).get();
		deckEditado.setUsuario(user);

		Deck deckEditar = deckRepo.findById(id).get();
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
		deckRepo.save(deckEditado);
		return "redirect:/decks";
	}
	@GetMapping("/delete/{id}")
	String deleteDeck(Model model, @PathVariable Integer id) {
		
		deckRepo.deleteById(id);
		return "redirect:/decks";
	}
	@PostMapping("/addncard")
	public String editarDeck(@ModelAttribute("deckNuevo") Deck deckNew, BindingResult bindingresult) {
		
		Usuario newUser = userRepo.findById(deckNew.getUsuario().getId()).get();
		
		newUser.getDecks().add(deckNew);
		deckNew.setUsuario(newUser);
		
		for(Carta card: deckNew.getCartas()) {
			card.getDecks().add(deckNew);
		}
		deckRepo.save(deckNew);
		
		return "redirect:/deck";
	}
	@GetMapping(value= "/{id}")
	String id(Model model, @PathVariable Integer id) {
		
		Deck deckMostrar = deckRepo.findById(id).get();
		model.addAttribute("deckMostrar", deckMostrar);
		model.addAttribute("deckEditado", new Deck());
		
		ArrayList<Usuario> misUsers = (ArrayList<Usuario>) userRepo.findAll();
		ArrayList<Carta> misCartas = (ArrayList<Carta>) cartaRepo.findAll();
		
			
		
		model.addAttribute("listarUsuarios" ,misUsers);
		model.addAttribute("listarCartas" ,misCartas);
	
		
		return "deck";
		
	}
}
