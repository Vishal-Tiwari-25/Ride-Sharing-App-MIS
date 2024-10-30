package com.ridesharing.rideshare.controller;

import com.ridesharing.rideshare.dto.FeedbackDTO;
import com.ridesharing.rideshare.model.Feedback;
import com.ridesharing.rideshare.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<FeedbackDTO> createFeedback(@RequestBody Feedback feedback) {
        Feedback createdFeedback = feedbackService.createFeedback(feedback);
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setId(createdFeedback.getId());
        feedbackDTO.setFeedbackMessage(createdFeedback.getFeedbackMessage());
        feedbackDTO.setRideId(createdFeedback.getRide().getId()); // Get the ride ID
        return ResponseEntity.ok(feedbackDTO);
    }
}
