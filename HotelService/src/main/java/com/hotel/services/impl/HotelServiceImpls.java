package com.hotel.services.impl;

import com.hotel.entites.Hotel;
import com.hotel.exceptions.ResourceNotFoundException;
import com.hotel.repository.HotelRepository;
import com.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class HotelServiceImpls implements HotelService {
   @Autowired
   private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        String randomId = UUID.randomUUID().toString();
        hotel.setId(randomId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel With given Id is Not Found"));
    }


}
