package br.com.encurtadorurlapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.encurtadorurlapi.model.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {
	
	Link findByChave(String chave);
	
}
