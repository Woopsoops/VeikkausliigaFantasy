package com.example.Veikkausliiga.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface PelipaikkaRepo extends CrudRepository<Pelipaikka, Long>
{

    List<Pelipaikka> findByPelipaikka(String pelipaikka);
    
}