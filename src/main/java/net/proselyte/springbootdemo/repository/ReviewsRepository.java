package net.proselyte.springbootdemo.repository;

import net.proselyte.springbootdemo.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Review, Long> {
}
