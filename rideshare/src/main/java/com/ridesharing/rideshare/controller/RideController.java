package com.ridesharing.rideshare.controller;

import com.ridesharing.rideshare.dto.RideDTO;
import com.ridesharing.rideshare.model.Ride;
import com.ridesharing.rideshare.model.User;
import com.ridesharing.rideshare.service.RideService;
import com.ridesharing.rideshare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    private final RideService rideService;
    private final UserService userService; // Add UserService here

    @Autowired
    public RideController(RideService rideService, UserService userService) {
        this.rideService = rideService;
        this.userService = userService; // Initialize UserService
    }

    @PostMapping
    public ResponseEntity<RideDTO> createRide(@RequestBody Ride ride) {
        // Check if ride's user is null before attempting to get ID
        if (ride.getUser() == null || ride.getUser().getId() == null) {
            throw new IllegalArgumentException("User ID must be provided in the ride");
        }

        // Fetch the user based on userId
        User user = userService.findById(ride.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        ride.setUser(user); // Associate the ride with the user
        Ride createdRide = rideService.createRide(ride);

        // Create RideDTO from the created Ride
        RideDTO rideDTO = new RideDTO();
        rideDTO.setId(createdRide.getId());
        rideDTO.setTripId(createdRide.getTripId());
        rideDTO.setDriverName(createdRide.getDriverName());
        rideDTO.setCabNumber(createdRide.getCabNumber());
        rideDTO.setStatus(createdRide.getStatus());
        rideDTO.setUserId(createdRide.getUser().getId()); // Now this will not be null

        return ResponseEntity.ok(rideDTO);
    }


    @GetMapping
    public ResponseEntity<List<RideDTO>> getAllRides() {
        List<Ride> rides = rideService.getAllRides();
        List<RideDTO> rideDTOs = rides.stream().map(ride -> {
            RideDTO rideDTO = new RideDTO();
            rideDTO.setId(ride.getId());
            rideDTO.setTripId(ride.getTripId());
            rideDTO.setDriverName(ride.getDriverName());
            rideDTO.setCabNumber(ride.getCabNumber());
            rideDTO.setStatus(ride.getStatus());
            rideDTO.setUserId(ride.getUser().getId()); // Get the user ID
            return rideDTO;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(rideDTOs);
    }
}
