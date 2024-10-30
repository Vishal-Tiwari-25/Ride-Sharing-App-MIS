package com.ridesharing.rideshare.service;

import com.ridesharing.rideshare.model.Ride;
import com.ridesharing.rideshare.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideService {
    private final RideRepository rideRepository;

    @Autowired
    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    public Ride createRide(Ride ride) {
        return rideRepository.save(ride);
    }

    // Other ride-related methods can be added here (e.g., search, book, cancel)
}
