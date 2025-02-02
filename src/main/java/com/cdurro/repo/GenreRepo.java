package com.cdurro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdurro.model.Genre;

@Repository
public interface GenreRepo extends JpaRepository<Genre, Long> {

}
