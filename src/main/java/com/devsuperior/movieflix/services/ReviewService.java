package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.MovieReviewDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repository.MovieRepository;
import com.devsuperior.movieflix.repository.ReviewRepository;

@Service
public class ReviewService {
 
	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserService userService;
	public List<MovieReviewDTO> findReviewByIdMovie(Long id) {
		
		List<Review> listReviews = repository.findByMovieId(id);
		
		return listReviews.stream().map(x -> new MovieReviewDTO(x,x.getUser())).collect(Collectors.toList());
	}

	public MovieReviewDTO insertReview(ReviewDTO dto) {
		UserDTO user = userService.profileUserLogged();
		
		Movie movie = movieRepository.getOne(dto.getMovieId());
		
		Review review = new Review();
		
		review.setMovie(movie);
		review.setUser(new User(user));
		review.setText(dto.getText());
		
		review = repository.save(review);
		return new MovieReviewDTO(review, review.getUser());
	}
}
