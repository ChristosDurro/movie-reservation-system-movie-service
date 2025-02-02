package com.cdurro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdurro.model.Genre;
import com.cdurro.service.GenreService;

@RestController
public class GenreController {
	
	
	@Autowired
	private GenreService genreService;
	
	@GetMapping("/genres")
	public List<Genre> getGenres() {
		
		return genreService.fetchAllGenres();
	}
	
	@GetMapping("/genres/{id}")
	public Genre getGenre(@PathVariable Long id) {
		
		return genreService.fetchGenre(id);
	}
	
	@PostMapping("/genres/create")
	public Genre createGenre(@RequestBody Genre genre) {
		
		return genreService.createGenre(genre);
	}
	
	@PostMapping("/genres/multiple/create")
	public List<Genre> createGenres(@RequestBody List<Genre> genres) {
		
		return genreService.createGenres(genres);
	}
}
