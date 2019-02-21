package br.com.encurtadorurlapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Link {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String link;
	
	@Column(unique = true)
	private String chave;
	
	private Long acessos;
	
	public Link() {
		super();
	}
	public Link(String link, String chave, Long acessos) {
		super();
		this.link = link;
		this.chave = chave;
		this.acessos = acessos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public Long getQtdCliques() {
		return acessos;
	}
	public void setQtdCliques(Long qtdCliques) {
		this.acessos = qtdCliques;
	}
	public void addClique() {
		this.acessos++;
	}
}
