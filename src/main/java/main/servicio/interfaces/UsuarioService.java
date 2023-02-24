package main.servicio.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import main.crud.UsuarioRepo;
import main.model.Usuario;
import main.modelo.dto.UsuarioDTO;



public interface UsuarioService extends UserDetailsService{
	
	public Usuario insertarUsuario (Usuario user);
	
	public void insertarUsuarioDTO (UsuarioDTO userDTO);

	public List<Usuario> listarUsuario();
	
	public Usuario obtenerUsuarioPorId (Integer id);
	
	public Usuario obtenerUsuarioPorNombre(String nombre);
	
	public void eliminarUsuario (Usuario user);
	
	public void eliminarUsuarioPorId (Integer id);
}
