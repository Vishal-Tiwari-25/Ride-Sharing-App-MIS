package com.ridesharing.rideshare.repository;

import com.ridesharing.rideshare.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {}
