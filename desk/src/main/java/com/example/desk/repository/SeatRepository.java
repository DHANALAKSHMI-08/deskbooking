package com.example.desk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.desk.model.Seat;
import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByLocation(String location);
}
