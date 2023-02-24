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

import main.crud.DeckRepo;
import main.crud.UsuarioRepo;
import main.model.Deck;
import main.model.Rol;
import main.model.Usuario;
import main.modelo.dto.UsuarioDTO;
import main.servicio.impl.UsuarioServiceImplements;

@RequestMapping("/usuarios")
@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioServiceImplements userDetailsService;
	
	@Autowired
	private DeckRepo deckRepo;

	@Autowired
	private UsuarioRepo userRepo;

	@GetMapping(value = { "", "/" })
	String homeUsers(Model model) {
		 ArrayList<Deck> misDecks =(ArrayList<Deck>) deckRepo.findAll();
		ArrayList<Usuario> misUsers = (ArrayList<Usuario>) userRepo.findAll();
		
		model.addAttribute("listaUsuarios", misUsers);
		
		model.addAttribute("editarUsuario", new Usuario());
		model.addAttribute("nuevoUsuario", new Usuario());
		return "usuarios";
	}

	@PostMapping("/edit/{id}")
	public String editarUsuario(@PathVariable Integer id, @ModelAttribute("editarUsuario") Usuario usuarioEditado,
			BindingResult bindingResult) {

		Usuario user = userRepo.findById(id).get();
		usuarioEditado.setNombre(usuarioEditado.getNombre());
		userRepo.save(usuarioEditado);

		return "redirect:/usuarios";
	}
	@GetMapping("/delete/{id}")
	String borrarUsuario(Model model, @PathVariable Integer id) {
		Usuario userAborrar= userRepo.findById(id).get();
		
		for(Deck d:userAborrar.getDecks()) {
			deckRepo.delete(d);
		}
		
		userRepo.deleteById(id);
		
		return "redirect:/usuarios";
	}
	@PostMapping("/add")
	public String editarUsuario(@ModelAttribute("usuarioNuevo") Usuario userNew, BindingResult bindingResult) {
		
		userRepo.save(userNew);
		
		return "redirect:/usuarios";
	}
	@GetMapping(value="/{id}")
	String idUsuario(Model model, @PathVariable Integer id) {
		
		Usuario userMostrar = userRepo.findById(id).get();
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
