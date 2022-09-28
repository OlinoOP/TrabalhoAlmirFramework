package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;

public class MovieReviewDTO extends ReviewDTO{

	private static final long serialVersionUID = 192709791697665745L;
	private UserDTO user;


	public MovieReviewDTO() {
		super();
	}
	
	public MovieReviewDTO(Review entity, User user) {
		super(entity);
		this.user = new UserDTO(user);
	}

	public MovieReviewDTO(UserDTO user) {
		super();
		this.user = user;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
}
