package com.example.Veikkausliiga.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.Veikkausliiga.domain.Pelipaikka;
import com.example.Veikkausliiga.domain.PelipaikkaRepo;

@CrossOrigin
@Controller

public class PelipaikkaController {
	
	//repository
	@Autowired
	private PelipaikkaRepo pelipaikkaRepo;
	
	// Pelipaikat jsoniksi
	@RequestMapping (value="api/pelipaikat", method = RequestMethod.GET)
	public @ResponseBody List<Pelipaikka> PelipaikkaRepo() {
		return (List<Pelipaikka>) pelipaikkaRepo.findAll();
	}
	
	//RESTful service to get by id
	@RequestMapping (method = RequestMethod.GET, path = "api/pelipaikat/{pelipaikkaid}")
	public @ResponseBody Optional<Pelipaikka> findPelipaikatRest (@PathVariable("pelipaikkaid") Long pelipaikkaid){
		return pelipaikkaRepo.findById(pelipaikkaid);
	}
	
	// RESTful service pelipaikan tallennukseen
    @RequestMapping(value="api/pelipaikat", method = RequestMethod.POST)
    public @ResponseBody Pelipaikka savePelipaikkaRest(@RequestBody Pelipaikka pelipaikka) {	
    	return pelipaikkaRepo.save(pelipaikka);
    }

}