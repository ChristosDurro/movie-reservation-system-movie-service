package com.cdurro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdurro.model.Genre;
import com.cdurro.repo.GenreRepo;

@Service
public class GenreService {

	@Autowired
	private GenreRepo repo;
	
	public List<Genre> fetchAllGenres() {
		
		List<Genre> genres = repo.findAll();
		
		return genres;
	}

	public Genre fetchGenre(Long id) {
		
		Genre genre = repo.findById(id).orElse(null);
		
		return genre;
	}

	public Genre createGenre(Genre genre) {
		
		Genre genreFetched = repo.findById(genre.getId()).orElse(null);
		
		if (genreFetched != null)
			return null;
		
		return repo.save(genre);
	}

	public List<Genre> createGenres(List<Genre> genres) {
		
		return repo.saveAll(genres);
	}

	
}
