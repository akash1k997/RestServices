package com.akash.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.rest.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

}
