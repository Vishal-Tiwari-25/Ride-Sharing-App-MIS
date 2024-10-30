package com.ridesharing.rideshare.dto;

public class RideDTO {
    private Long id;
    private String tripId;
    private String driverName;
    private String cabNumber;
    private String status;
    private Long userId; // Reference to the user ID who created the ride

    // Constructors
    public RideDTO() {}

    public RideDTO(Long id, String tripId, String driverName, String cabNumber, String status, Long userId) {
        this.id = id;
        this.tripId = tripId;
        this.driverName = driverName;
        this.cabNumber = cabNumber;
        this.status = status;
        this.userId = userId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getCabNumber() {
        return cabNumber;
    }

    public void setCabNumber(String cabNumber) {
        this.cabNumber = cabNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
