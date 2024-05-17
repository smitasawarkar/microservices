package com.hotel.controller;

import com.hotel.entites.Hotel;
import com.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
   @Autowired
   private HotelService hotelService;

    @PostMapping("/createUser")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        Hotel hotel1 = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }


    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelById(hotelId));
    }


    @GetMapping("/getAllHotel")
    public ResponseEntity <List<Hotel>> getAllHotel()
    {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }
}
