package com.cdurro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdurro.model.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
	
}
