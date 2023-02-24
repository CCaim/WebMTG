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
public class UsuarioServiceImplements implements UsuarioService {

	@Autowired
	private UsuarioRepo usuarioRepo;

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepo.findByUsername(username);

		if (usuario.isPresent()) {
			Usuario springUserMio = usuario.get();
			return springUserMio;
		} else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}

	}

	@Override
	public Usuario insertarUsuario(Usuario user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertarUsuarioDTO(UsuarioDTO userDTO) {
		Usuario nuevoUsuario = new Usuario(userDTO.getNombre(), userDTO.getUsername(),
				passwordEncoder.encode(userDTO.getPassword()));

		nuevoUsuario.getRoles().add(new Rol("ROLE_ADMIN"));
		usuarioRepo.save(nuevoUsuario);
	
	}

	@Override
	public List<Usuario> listarUsuario() {
		
		return usuarioRepo.findAll();
	}

	@Override
	public Usuario obtenerUsuarioPorId(Integer id) {
		// TODO Auto-generated method stub
		return usuarioRepo.findById(id).get();
	}

	@Override
	public Usuario obtenerUsuarioPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return usuarioRepo.findByUsername(nombre).get();
	}

	@Override
	public void eliminarUsuario(Usuario user) {
		usuarioRepo.delete(user);

	}

	@Override
	public void eliminarUsuarioPorId(Integer id) {
		usuarioRepo.delete(usuarioRepo.findById(id).get());

	}

}
