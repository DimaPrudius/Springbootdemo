package net.proselyte.springbootdemo.controller;

import net.proselyte.springbootdemo.model.Car;
import net.proselyte.springbootdemo.model.Review;
import net.proselyte.springbootdemo.repository.CarsRepository;
import net.proselyte.springbootdemo.service.ReviewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReviewsController {

    private final ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;

    }

    @GetMapping("reviews")
    public String findAll(Model model) {
        List<Review> reviews = reviewsService.findAll();
        model.addAttribute("reviews", reviews);
        return "review-list";
    }

    @GetMapping("/review-create")
    public String createReviewsForm( Review review) {
        return "review-create";
    }

    @PostMapping("/review-create")
    public String createReviews(Review reviews) {
        reviewsService.saveReviews(reviews);
        return "redirect:/reviews";
    }

    @GetMapping("review-delete/{carId}")
    public String deleteReviews(@PathVariable("carId") Long carId) {
        reviewsService.deleteById(carId);
        return "redirect:/reviews";
    }

    @GetMapping("review-update/{carId}")
    public String updateReviewsForm(@PathVariable("carId") Long carId, Model model) {
        Review review = reviewsService.findById(carId);
        model.addAttribute("review", review);
        return "/review-update";
    }

    @PostMapping("review-update")
    public String updateReviews(Review reviews) {
        reviewsService.saveReviews(reviews);
        return "redirect:/reviews";

    }
}
