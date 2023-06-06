package main.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import main.model.CartasDecks;
import main.model.Deck;
import main.model.Usuario;
import main.servicio.impl.UsuarioServiceImplements;

@RequestMapping("/decks")
@Controller
public class DeckController {
	
	@Autowired
	UsuarioServiceImplements userDetailsService;
	
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
		Usuario UsuLog = new Usuario();
		
		model.addAttribute("listarCartas", misCartas);
		model.addAttribute("listarUsuarios", misUsuarios);
		model.addAttribute("listarDecks", misDecks);
		model.addAttribute("usuarioLogueado", UsuLog);
		model.addAttribute("deckEditar", new Deck());
		model.addAttribute("deckNuevo", new Deck());
		return "decks";

	}

	@PostMapping("/edit/{id}")
	public String editarDeck(@PathVariable Integer id, @ModelAttribute("deckEditar") Deck deckEditado,
	        BindingResult bindingresult) {

	    Usuario user = userRepo.findById(deckEditado.getUsuario().getId()).get();
	    deckEditado.setUsuario(user);

	    Deck deckEditar = deckRepo.findById(id).get();

	    // Remover las relaciones anteriores
	    deckEditar.getCartas().clear();

	    // Actualizar el nombre del deck
	    deckEditar.setNombre(deckEditado.getNombre());

	    // Agregar las nuevas relaciones
	    deckEditar.setCartas(deckEditado.getCartas());

	    deckRepo.save(deckEditar);
	    return "redirect:/decks";
	}



	@PostMapping("/delete/{id}")
	public String deleteDeck(Model model, @PathVariable Integer id) {
		
		deckRepo.deleteById(id);
		return "redirect:/decks";
	}
	@PostMapping("/addncard")
	public String editarDeck(@ModelAttribute("deckNuevo") Deck deckNew, BindingResult bindingresult) {
		
		Usuario UsuLog = getUsernameUsuarioLogueado();
		
		UsuLog.getDecks().add(deckNew);
		deckNew.setUsuario(UsuLog);
		
		for(CartasDecks card: deckNew.getCartas()) {
			card.getDecks().add(deckNew);
		}
		deckRepo.save(deckNew);
		
		return "redirect:/decks";
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
	private Usuario getUsernameUsuarioLogueado() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
            
            Usuario u = userDetailsService.obtenerUsuarioPorNombre(userDetails.getUsername());
            return u;
        }
        
        return null; // si no se encuentra un usuario logueado
    }
	
}

//patata
