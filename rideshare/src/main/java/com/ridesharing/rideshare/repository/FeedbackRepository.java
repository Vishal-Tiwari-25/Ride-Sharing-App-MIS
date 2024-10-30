package com.ridesharing.rideshare.repository;

import com.ridesharing.rideshare.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {}
