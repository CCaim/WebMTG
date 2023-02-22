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

import main.model.Deck;
import main.model.Rol;
import main.model.Usuario;
import main.modelo.dto.UsuarioDTO;
import main.servicio.impl.DeckServiceImplements;
import main.servicio.impl.UsuarioServiceImplements;

@RequestMapping("/usuarios")
@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioServiceImplements userDetailsService;
	
	@Autowired
	private DeckServiceImplements deckSI;

	@Autowired
	private UsuarioServiceImplements userSI;

	@GetMapping(value = { "", "/" })
	String homeUsers(Model model) {
		 ArrayList<Deck> misDecks =(ArrayList<Deck>) deckSI.listarDeck();
		ArrayList<Usuario> misUsers = (ArrayList<Usuario>) userSI.listarUsuario();
		
		model.addAttribute("listaUsuarios", misUsers);
		
		model.addAttribute("editarUsuario", new Usuario());
		model.addAttribute("nuevoUsuario", new Usuario());
		return "usuarios";
	}

	@PostMapping("/edit/{id}")
	public String editarUsuario(@PathVariable Integer id, @ModelAttribute("editarUsuario") Usuario usuarioEditado,
			BindingResult bindingResult) {

		Usuario user = userSI.obtenerUsuarioPorId(id);
		usuarioEditado.setNombre(usuarioEditado.getNombre());
		userSI.insertarUsuario(usuarioEditado);

		return "redirect:/usuarios";
	}
	@GetMapping("/delete/{id}")
	String borrarUsuario(Model model, @PathVariable Integer id) {
		Usuario userAborrar= userSI.obtenerUsuarioPorId(id);
		
		for(Deck d:userAborrar.getDecks()) {
			deckSI.eliminarDeck(d);
		}
		
		userSI.eliminarUsuarioPorId(id);
		
		return "redirect:/usuarios";
	}
	@PostMapping("/add")
	public String editarUsuario(@ModelAttribute("usuarioNuevo") Usuario userNew, BindingResult bindingResult) {
		
		userSI.insertarUsuario(userNew);
		
		return "redirect:/usuarios";
	}
	@GetMapping(value="/{id}")
	String idUsuario(Model model, @PathVariable Integer id) {
		
		Usuario userMostrar = userSI.obtenerUsuarioPorId(id);
		model.addAttribute("userMostrar", userMostrar);
		
		return "usuario";
	}
	@GetMapping("/registro")
    public String mostrarRegistro(Model model, @ModelAttribute("usuarioNuevo") UsuarioDTO usuarioNew, BindingResult bindingresult) {

        model.addAttribute("newUserDTO", new UsuarioDTO());

        return "registro";
    }

    @PostMapping("/addRegistro")
    public String addRegistro(@ModelAttribute("usuarioNuevo") UsuarioDTO usuarioNew, BindingResult bindingresult) {

        userDetailsService.insertarUsuarioDTO(usuarioNew);

        return "login";
    }
    private boolean elUsuarioLogueadoesAdmin() {
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	UserDetails userDetails = null;
    	
    	if (principal instanceof UserDetails) {
    		
    		userDetails =(UserDetails) principal;
    		
    		Usuario u = userDetailsService.obtenerUsuarioPorNombre(userDetails.getUsername());
    		
    		for (Rol r: u.getRoles()) {
    			
    			if(r.getNombre().compareTo("ROLE_ADMIN") == 0) {
    				return true;
    			}
    			
    		}
    	}
    	return false;
    }
}
