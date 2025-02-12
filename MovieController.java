package com.cdurro.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdurro.model.Movie;
import com.cdurro.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("movies")
	public ResponseEntity<List<Movie>> allMovies() {
		return movieService.getMovies();
	}
	
	@GetMapping("movies/{id}")
	public ResponseEntity<Movie> oneMovie(@PathVariable Long id) {
		return movieService.getMovie(id);
	}
	
	@PostMapping("movies/multiple")
	public ResponseEntity<List<Movie>> multipleMovies(@RequestBody List<Long> movieIds) {
		
		return movieService.getMoviesByIds(movieIds);
	}
	
	@PostMapping("movies/create")
	public ResponseEntity<Movie> newMovie(@RequestBody Movie movie) {
		return movieService.createMovie(movie);
	}
	
	@PatchMapping("movies/update/{id}")
	public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
		return movieService.updateMovie(id, updates);
	}
}
