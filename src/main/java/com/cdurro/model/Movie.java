package com.cdurro.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int duration;
	private int releaseDate;
	private String image;
	private String title;
	private String description;
	private Date premiereDate;
	private Date lastShowing;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
		name = "movie_genre",
		joinColumns = @JoinColumn(name = "movie_id"),
		inverseJoinColumns = @JoinColumn(name = "genre_id")
	)
	private List<Genre> genres;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPremiereDate() {
		return premiereDate;
	}
	public void setPremiereDate(Date premiereDate) {
		this.premiereDate = premiereDate;
	}
	public Date getLastShowing() {
		return lastShowing;
	}
	public void setLastShowing(Date lastShowing) {
		this.lastShowing = lastShowing;
	}
	public List<Genre> getGenres() {
		return genres;
	}
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", duration=" + duration + ", releaseDate=" + releaseDate + ", image=" + image
				+ ", title=" + title + ", description=" + description + ", premiereDate=" + premiereDate
				+ ", lastShowing=" + lastShowing + ", genres=" + genres + "]";
	}
}
