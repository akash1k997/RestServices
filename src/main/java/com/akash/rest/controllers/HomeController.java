package com.akash.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akash.rest.dao.AlienRepo;
import com.akash.rest.exception.APIException;
import com.akash.rest.model.Alien;

@RestController
public class HomeController {
	
	@Autowired
	AlienRepo repo;
	
	@GetMapping(path="/aliens",produces= {"application/xml","application/json"})
	public List<Alien> getAliens() {
		return repo.findAll();
	}
	
	@GetMapping("/aliens/{aid}")
	public Alien getAlien(@PathVariable("aid") int aid) {
		Alien alien = repo.findById(aid).orElseThrow(()->new APIException("User with id "+aid+" not found"));
		return alien;
	}
	
	@PostMapping("/aliens")
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping("/aliens/{aid}")
	public String removeAlien(@PathVariable("aid") int aid) {
		Alien a = repo.getOne(aid);
		repo.delete(a);
		return "deleted";
	}
	
	@PutMapping("/aliens")
	public Alien saveOrUpdate(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@PatchMapping("/aliens")
	public Alien Update(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}

}
