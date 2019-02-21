package br.com.encurtadorurlapi.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.encurtadorurlapi.model.Usuario;
import br.com.encurtadorurlapi.repository.UsuarioRepository;

@Service("UserDetailsService")
public class UsuarioAuthService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String usuario) 
										throws UsernameNotFoundException {
		Usuario usr = repository.findByUsuario(usuario);
		
		if(usr == null) {
			throw new UsernameNotFoundException(usuario);
		}
		
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("Base"));
		
		return new User(usr.getUsuario(), usr.getSenha(), grantedAuthorities);
	}

}
