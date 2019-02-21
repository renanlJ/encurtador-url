package br.com.encurtadorurlapi.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.encurtadorurlapi.model.Link;
import br.com.encurtadorurlapi.model.LinkDTO;
import br.com.encurtadorurlapi.repository.LinkRepository;

@Service
public class LinkService {
	
	@Autowired
	private LinkRepository repository;
	
	private static final String PAGINA_INICIAL = "http://wwww.paginainicial.com.br/";
	
	public LinkDTO criaUrl(String url, String urlAtual) {
		
		// Trecho para criar chave com 5 caracteres
		UUID uuid = UUID.randomUUID();
		String myRandom = uuid.toString();
		String chave = myRandom.substring(0,5);
		
		Link link = new Link(url, chave, 0l);
		repository.save(link);
		
		return new LinkDTO(urlAtual + chave);
	}
	
	public String pegaUrl(String chave) {
		String url = PAGINA_INICIAL;
		
		Link link = repository.findByChave(chave);
		
		if(link != null) {
			link.addClique();
			repository.save(link);
			url = link.getLink();
		}
		
		return url;
	}

}
