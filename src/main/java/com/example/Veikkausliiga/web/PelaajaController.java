package com.example.Veikkausliiga.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Veikkausliiga.domain.*;


@CrossOrigin
@Controller
public class PelaajaController {
	
	//repository
	@Autowired
	private PelaajaRepo pelaajaRepo;
	
	// kaikki pelaajat
    @RequestMapping(value={"/", "/pelaajalist"})
    public String pelaajaList(Model model) {	
        model.addAttribute("pelaajat", pelaajaRepo.findAll());
        return "pelaajalist";
    }
    
    //Poistha pelaaja
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePelaaja(@PathVariable("pelaajaid") Long pelaajaid, Model model) {
    	pelaajaRepo.deleteById(pelaajaid);
        return "redirect:../pelaajalist";
    }   

	
	// Pelaajat jsoniksi
	@RequestMapping (value="api/pelaajat", method = RequestMethod.GET)
	public @ResponseBody List<Pelaaja> PelaajaRepo() {
		return (List<Pelaaja>) pelaajaRepo.findAll();
	}
	
	//RESTful service to get by id
	@RequestMapping (method = RequestMethod.GET, path = "/{pelaajaid}")
	public @ResponseBody Optional<Pelaaja> findPelaajaRest (@PathVariable("pelaajaid") Long pelaajaid){
		return pelaajaRepo.findById(pelaajaid);
	}

	// RESTful service pelipaikan tallennukseen
    @RequestMapping(value="api/pelaajat", method = RequestMethod.POST)
    public @ResponseBody Pelaaja savePelaajaRest(@RequestBody Pelaaja pelaaja) {	
    	return pelaajaRepo.save(pelaaja);
    }
}
