package com.cdurro.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cdurro.model.Genre;
import com.cdurro.model.Movie;
import com.cdurro.repo.GenreRepo;
import com.cdurro.repo.MovieRepo;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepo movieRepo;
	
	@Autowired
	private GenreRepo genreRepo;
	
	@Autowired
	private GenreService genreService;
	
	public ResponseEntity<List<Movie>> getMovies() {
		
		List<Movie> movies = movieRepo.findAll();
		
		return ResponseEntity.ok(movies);
	}
	
	public ResponseEntity<Movie> getMovie(Long id) {
		
		Movie movie = movieRepo.findById(id).orElse(null);
		
		return ResponseEntity.ok(movie);
	}
	
	public ResponseEntity<List<Movie>> getMoviesByIds(List<Long> movieIds) {
		
		List<Movie> movies = movieRepo.findAllById(movieIds);
		
		return ResponseEntity.ok(movies);
	}
	
	public ResponseEntity<Movie> createMovie(Movie movie) {
		
		 List<Genre> genres = movie.getGenres().stream().map(genre -> {
		        if (genre.getId() != null) {
		            return genreService.fetchGenre(genre.getId());
		        } else {
		            return genreService.createGenre(genre);
		        }
		    }).collect(Collectors.toList());
		 
		 movie.setGenres(genres);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(movieRepo.save(movie));
	}

	public ResponseEntity<Movie> updateMovie(Long id, Map<String, Object> updates) {
		Optional<Movie> movieOptional = movieRepo.findById(id);
		
		if (movieOptional.isPresent()) {
			
			Movie movie = movieOptional.get();
			
			updates.forEach((key, value) -> {
				switch (key) {
					case "description":
						movie.setDescription((String) value);
						break;
					case "Genres":
						List<Long> genreIds = (List<Long>) value;
						List<Genre> genres = genreRepo.findAllById(genreIds);
						movie.setGenres(genres);
						break;
					case "image":
						movie.setImage((String) value);
						break;
					case "lastShowing":
						movie.setLastShowing((Date) value);
						break;
					case "premiereDate":
						movie.setPremiereDate((Date) value);
						break;
					case "releaseDate":
						movie.setReleaseDate((Integer) value);
						break;
					case "title":
						movie.setTitle((String) value);
						break;
				}
			});
			
			
			movieRepo.save(movie);

			return ResponseEntity.ok(movie);	
			
		}
		return ResponseEntity.notFound().build();
	}
}
