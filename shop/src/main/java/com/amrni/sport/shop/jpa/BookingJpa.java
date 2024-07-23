package com.amrni.sport.shop.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amrni.sport.shop.model.Booking;

public interface BookingJpa extends JpaRepository<Booking, Integer> {

    List<Booking> findByUserIdAndBookStatus(Integer userId, String status);
}

