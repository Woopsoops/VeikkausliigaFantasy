package com.example.Veikkausliiga;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Veikkausliiga.domain.Joukkue;
import com.example.Veikkausliiga.domain.Pelaaja;
import com.example.Veikkausliiga.domain.PelaajaRepo;
import com.example.Veikkausliiga.domain.Pelipaikka;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PelaajaRepoTest {

	@Autowired
	private PelaajaRepo repo;
	
	@Test
	public void findBySukunimiShouldReturnPelaaja () {
		List <Pelaaja> pelaajat = repo.findBySukunimi("Keto");
				
				assertThat(pelaajat).hasSize(1);
				assertThat(pelaajat.get(0).getEtunimi()).isEqualTo("Hugo");
	}
	
	@Test
	public void luoPelaaja() {
		Pelaaja pelaaja = new Pelaaja ("Matti", "Meikalainen", 24, 750, new Pelipaikka ("Testipelipaikka"), new Joukkue("Testijengi"));
		repo.save(pelaaja);
		assertThat(pelaaja.getPelaajaid()).isNotNull();
	}
	
	
	
	
	
}
