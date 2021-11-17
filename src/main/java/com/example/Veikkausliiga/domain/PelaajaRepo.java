package com.example.Veikkausliiga.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface PelaajaRepo extends CrudRepository<Pelaaja, Long>
{

    List<Pelaaja> findBySukunimi(String sukunimi);
   
}