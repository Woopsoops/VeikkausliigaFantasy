package com.example.Veikkausliiga.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Joukkue {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long joukkueid;
	private String joukkue;

	@OneToMany (cascade = CascadeType.ALL, mappedBy = "joukkue")
	@JsonIgnoreProperties("joukkue")
	private List<Pelaaja> pelaajat;
	
	public Joukkue () {}

	public Joukkue(String joukkue) {
		super();
		this.joukkue = joukkue;
	}

	public Long getJoukkueid() {
		return joukkueid;
	}

	public void setJoukkueid(Long joukkueid) {
		this.joukkueid = joukkueid;
	}

	public String getJoukkue() {
		return joukkue;
	}

	public void setJoukkue(String joukkue) {
		this.joukkue = joukkue;
	}

	public List<Pelaaja> getPelaajat() {
		return pelaajat;
	}

	public void setPelaajat(List<Pelaaja> pelaajat) {
		this.pelaajat = pelaajat;
	}

	@Override
	public String toString() {
		return "Joukkue [joukkueid=" + joukkueid + ", joukkue=" + joukkue + "]";
	}
	
	
}
