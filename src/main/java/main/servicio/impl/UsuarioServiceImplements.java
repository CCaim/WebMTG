package main.servicio.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import main.crud.UsuarioRepo;
import main.model.Rol;
import main.model.Usuario;
import main.modelo.dto.UsuarioDTO;
import main.servicio.interfaces.UsuarioService;


@Service
public class UsuarioServiceImplements implements  UsuarioService {

	@Autowired
	private UsuarioRepo UsuarioRepo ;
	private List<Usuario> crudUsuario;
	
	//@Autowired
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	

	@Override
	public Usuario insertarUsuarioDTO(UsuarioDTO userDTO) {
		Usuario newUser = new Usuario(userDTO.getNombre(),userDTO.getUsername(),passwordEncoder.encode(userDTO.getPassword()));
		newUser.getRoles().add(new Rol("ROLE_ADMIN"));
		
		return UsuarioRepo.save(newUser);
	}
	
	@Override
	public Usuario insertarUsuario(Usuario user) {
		 
		return  UsuarioRepo.save(user);
	}
	
	@Override
	public List<Usuario> listarUsuario() {
		return UsuarioRepo.findAll();
		
	}

	@Override
	public Usuario obtenerUsuarioPorId(Integer id) {
		int idInt = (int) id;
		return UsuarioRepo.findById(idInt).orElse((null));
	}

	
	
	@Override
	public void eliminarUsuarioPorId(Integer id) {
		//int idInt = (int) id;
		UsuarioRepo.deleteById(id);
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//return UsuarioRepo.findByUsername(username).orElse((null));
		Optional<Usuario> usuario = UsuarioRepo.findByUsername(username);
		
		if(usuario.isPresent()) {

			User springUser = new User( usuario.get().getUsername(), usuario.get().getPassword(), mapearAutoridadesRoles(usuario.get().getRoles()));
			
			Usuario springUserMio =  usuario.get(); 
			//springUserMio.setRoles(mapearAutoridadesRoles(usuario.get().getRoles()));
			return springUserMio;
		}
		else throw new  UsernameNotFoundException("Usuario o password incorrecto");
	}
	
	private  Collection<? extends GrantedAuthority>   mapearAutoridadesRoles(Collection<Rol> roles){
		
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
				 
	}


	@Override
	public void eliminarUsuario(Integer id) {
		
		UsuarioRepo.deleteById(id);
		
	}

	@Override
	public Usuario obtenerUsuarioPorNombre(String username) {
		
		return UsuarioRepo.findByUsername(username).orElse((null));
	}
	 

}
