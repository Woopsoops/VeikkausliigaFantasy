package com.example.Veikkausliiga.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface JoukkueRepo extends CrudRepository<Joukkue, Long>
	{

	    List<Joukkue> findByJoukkue(String joukkue);
	    
	}
