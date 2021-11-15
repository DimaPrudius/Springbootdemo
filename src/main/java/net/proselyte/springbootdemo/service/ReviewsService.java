package net.proselyte.springbootdemo.service;

import net.proselyte.springbootdemo.model.Review;
import net.proselyte.springbootdemo.repository.ReviewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsService {

    private final ReviewsRepository reviewsRepository;

    public ReviewsService(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }
    public Review findById(Long id){
        return reviewsRepository.getOne(id);
    }
    public List<Review> findAll(){
        return reviewsRepository.findAll();
    }
    public Review saveReviews(Review reviews){
        return reviewsRepository.save(reviews);

    }
    public void deleteById(Long id){
        reviewsRepository.deleteById(id);
    }
}
