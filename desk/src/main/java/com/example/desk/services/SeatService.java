package com.example.desk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desk.model.Seat;
import com.example.desk.repository.SeatRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getSeatsForLocation(String location) {
        return seatRepository.findByLocation(location);
    }

    public void bookSeat(Long seatId, String user, String startTime, String endTime) {
        Seat seat = seatRepository.findById(seatId).orElseThrow(() -> new IllegalArgumentException("Invalid seat ID"));
        seat.setBooked(true);
        seat.setBookedBy(user);
        seat.setStartTime(startTime);
        seat.setEndTime(endTime);
        seatRepository.save(seat);
    }

    public void updateSeatStatus() {
        List<Seat> seats = seatRepository.findAll();
        LocalDateTime now = LocalDateTime.now();
        for (Seat seat : seats) {
            LocalDateTime seatEndTime = LocalDateTime.parse(seat.getEndTime());
            if (seat.isBooked() && now.isAfter(seatEndTime)) {
                seat.setBooked(false);
                seat.setBookedBy(null);
                seat.setStartTime(null);
                seat.setEndTime(null);
                seatRepository.save(seat);
            }
        }
    }
}
