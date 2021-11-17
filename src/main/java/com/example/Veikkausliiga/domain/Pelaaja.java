package com.example.Veikkausliiga.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Pelaaja {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long pelaajaid;
	private String etunimi;
	private String sukunimi;
	private int ika;
	private int hinta;
	
	@ManyToOne
	@JsonIgnoreProperties ("pelaajat")
	@JoinColumn (name= "pelipaikkaid")
	private Pelipaikka pelipaikka;
	
	@ManyToOne
	@JoinColumn (name= "joukkueid")
	private Joukkue joukkue;
	
	public Pelaaja () {}

	public Pelaaja( String etunimi, String sukunimi, int ika, int hinta, Pelipaikka pelipaikka,
			Joukkue joukkue) {
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.ika = ika;
		this.hinta = hinta;
		this.pelipaikka = pelipaikka;
		this.joukkue = joukkue;
	}

	public Long getPelaajaid() {
		return pelaajaid;
	}

	public void setPelaajaid(Long pelaajaid) {
		this.pelaajaid = pelaajaid;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public int getIka() {
		return ika;
	}

	public void setIka(int ika) {
		this.ika = ika;
	}

	public int getHinta() {
		return hinta;
	}

	public void setHinta(int hinta) {
		this.hinta = hinta;
	}

	public Pelipaikka getPelipaikka() {
		return pelipaikka;
	}

	public void setPelipaikka(Pelipaikka pelipaikka) {
		this.pelipaikka = pelipaikka;
	}

	public Joukkue getJoukkue() {
		return joukkue;
	}

	public void setJoukkue(Joukkue joukkue) {
		this.joukkue = joukkue;
	}

	@Override
	public String toString() {
		return "Pelaaja [pelaajaid=" + pelaajaid + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", ika=" + ika
				+ ", hinta=" + hinta + ", pelipaikka=" + this.getPelipaikka() + ", joukkue=" + this.getJoukkue() + "]";
	}
	
	
}
