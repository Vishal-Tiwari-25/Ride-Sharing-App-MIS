package com.ridesharing.rideshare.repository;

import com.ridesharing.rideshare.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {}
