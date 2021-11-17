package com.example.Veikkausliiga.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Pelipaikka {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long pelipaikkaid;
	private String pelipaikka;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "pelipaikka")
	@JsonIgnoreProperties ("pelipaikka")
	private List<Pelaaja> pelaajat;
	
	public Pelipaikka () {}

	public Pelipaikka(String pelipaikka) {
		super();
		this.pelipaikka = pelipaikka;
	}

	public Long getPelipaikkaid() {
		return pelipaikkaid;
	}

	public void setPelipaikkaid(Long pelipaikkaid) {
		this.pelipaikkaid = pelipaikkaid;
	}

	public String getPelipaikka() {
		return pelipaikka;
	}

	public void setPelipaikka(String pelipaikka) {
		this.pelipaikka = pelipaikka;
	}

	public List<Pelaaja> getPelaajat() {
		return pelaajat;
	}

	public void setPelaajat(List<Pelaaja> pelaajat) {
		this.pelaajat = pelaajat;
	}

	@Override
	public String toString() {
		return "Pelipaikka [pelipaikkaid=" + pelipaikkaid + ", pelipaikka=" + pelipaikka + "]";
	}
	
	
	

}
