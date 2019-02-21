package br.com.encurtadorurlapi.resource;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.encurtadorurlapi.model.LinkDTO;
import br.com.encurtadorurlapi.service.LinkService;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class LinksResource {
	
	@Autowired
	private LinkService service;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public LinkDTO criaLinkEncurtado(@RequestBody LinkDTO link,
									HttpServletRequest request) {
		return service.criaUrl(link.getLink(), request.getRequestURL().toString());
	}
	
	@GetMapping("/{chave}")
	@ResponseStatus(code=HttpStatus.FOUND)
	public void redireciona(@PathVariable String chave,
								HttpServletResponse response) throws IOException {
		response.sendRedirect(service.pegaUrl(chave));
	}
}
