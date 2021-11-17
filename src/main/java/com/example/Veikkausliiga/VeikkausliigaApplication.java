package com.example.Veikkausliiga;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Veikkausliiga.domain.*;


@SpringBootApplication
public class VeikkausliigaApplication {
	
	private static final Logger log = LoggerFactory.getLogger(VeikkausliigaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(VeikkausliigaApplication.class, args);
	}
	
		@Bean
		public CommandLineRunner VeikkausliigaDemo(PelaajaRepo prepo, PelipaikkaRepo pprepo, JoukkueRepo jrepo) {
			return (args) -> {
				log.info("Tallenna joukkueet");
				jrepo.save(new Joukkue("HJK"));
				jrepo.save(new Joukkue("FC Inter"));
				jrepo.save(new Joukkue("FC Honka"));
				
				log.info("Tallenna pelipaikat");
				pprepo.save(new Pelipaikka("Maalivahti"));
				pprepo.save(new Pelipaikka("Puolustaja"));
				pprepo.save(new Pelipaikka("Keskikenttä"));


				log.info("Tallenna testipelaajia");
				prepo.save(new Pelaaja("Hugo", "Keto", 23, 200, pprepo.findByPelipaikka("Maalivahti").get(0), jrepo.findByJoukkue("HJK").get(0) ));
				prepo.save(new Pelaaja("Rick", "Ketting", 25, 400, pprepo.findByPelipaikka("Puolustaja").get(0),jrepo.findByJoukkue("FC Inter").get(0) ));	
				
				log.info("etsi ja näytä pelaajatt");
				for (Pelaaja pelaaja : prepo.findAll()) {
					log.info(pelaaja.toString());
				}
		
		};
		
	}
}
	
		

