package com.example.Veikkausliiga.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.Veikkausliiga.domain.Joukkue;
import com.example.Veikkausliiga.domain.JoukkueRepo;


@CrossOrigin
@Controller

public class JoukkueController {
	
	//repository
	@Autowired
	private JoukkueRepo joukkueRepo;
	
	// Joukkueet jsoniksi
	@RequestMapping (value="api/joukkueet", method = RequestMethod.GET)
	public @ResponseBody List<Joukkue> JoukkueRepo () {
		return (List<Joukkue>) joukkueRepo.findAll();
	}
	
	//haku ID:llä
	@RequestMapping (method = RequestMethod.GET, path = "/{joukkueid}")
	public @ResponseBody Optional<Joukkue> findJoukkueRest (@PathVariable("joukkueid") Long joukkueid){
		return joukkueRepo.findById(joukkueid);
	}
	
	// RESTful service joukkueen tallennukseen
    @RequestMapping(value="api/joukkueet", method = RequestMethod.POST)
    public @ResponseBody Joukkue saveJoukkueRest(@RequestBody Joukkue joukkue) {	
    	return joukkueRepo.save(joukkue);
    }

}
