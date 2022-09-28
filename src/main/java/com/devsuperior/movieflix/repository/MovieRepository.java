package com.devsuperior.movieflix.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Movie;


public interface MovieRepository extends JpaRepository<Movie, Long>{



	@Query("SELECT obj FROM Movie obj WHERE "
			+ " ( :genreId IS NULL or obj.genre.id = :genreId ) order by obj.title")
	Page<Movie> findMovieByGenreId(Long genreId, Pageable pageable);
}
