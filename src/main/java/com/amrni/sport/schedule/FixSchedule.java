package com.amrni.sport.schedule;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.amrni.sport.shop.jpa.BookingJpa;
import com.amrni.sport.shop.model.Booking;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class FixSchedule {

    private final BookingJpa bookingJpa;

//    @Scheduled(cron = "0 0 0/1 * * ? ")
    @Scheduled(fixedDelay = 1000)
    public void updateBooking() {
        List<Booking> allBookingList = bookingJpa.findByBookStatusAndBookingEndTimeLessThan(Booking.BOOKING, LocalDateTime.now());
        allBookingList.forEach(booking -> {
            booking.setBookStatus(Booking.COMPLETE);
            booking.setCompleteTime(booking.getBookingEndTime());
        });
        bookingJpa.saveAll(allBookingList);
    }
}
