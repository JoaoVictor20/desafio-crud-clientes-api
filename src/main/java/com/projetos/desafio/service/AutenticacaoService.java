package com.projetos.desafio.service;

import com.projetos.desafio.dao.AutenticacaoDao;
import com.projetos.desafio.models.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService{

    @Autowired
    private AutenticacaoDao usuarioDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usuarioDao.findByLogin(username);
	}
	
	public Usuario buscarPorLogin(String login) throws UsernameNotFoundException {
		return usuarioDao.findByLogin(login);
	}
	
	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioDao.save(usuario);
	}
}