package com.ridesharing.rideshare.dto;

public class FeedbackDTO {
    private Long id;
    private String feedbackMessage;
    private Long rideId; // Reference to the ride ID for which feedback is given

    // Constructors
    public FeedbackDTO() {}

    public FeedbackDTO(Long id, String feedbackMessage, Long rideId) {
        this.id = id;
        this.feedbackMessage = feedbackMessage;
        this.rideId = rideId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }

    public void setFeedbackMessage(String feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
    }

    public Long getRideId() {
        return rideId;
    }

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }
}
