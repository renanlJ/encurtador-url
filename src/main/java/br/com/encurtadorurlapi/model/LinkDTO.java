package br.com.encurtadorurlapi.model;

public class LinkDTO {
	
	private String link;
	
	public LinkDTO() {
		super();
	}
	public LinkDTO(String link) {
		super();
		this.link = link;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
