package com.example.desk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.desk.services.SeatService;

@Controller
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/seats/ckc")
    public String ckcSeats(Model model) {
        model.addAttribute("seats", seatService.getSeatsForLocation("CKC-Chennai"));
        return "CKCSeats";
    }

    @GetMapping("/seats/mepz")
    public String mepzSeats(Model model) {
        model.addAttribute("seats", seatService.getSeatsForLocation("MEPZ-Chennai"));
        return "mepzSeats";
    }

    @PostMapping("/bookSeat")
    public String bookSeat(@RequestParam Long seatId, @RequestParam String user, @RequestParam String startTime, @RequestParam String endTime) {
        seatService.bookSeat(seatId, user, startTime, endTime);
        return "redirect:/seats/ckc";
    }
}
