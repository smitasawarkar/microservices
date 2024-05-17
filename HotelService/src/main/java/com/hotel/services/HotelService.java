package com.hotel.services;

import com.hotel.entites.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);
    List<Hotel> getAllHotels();

    Hotel getHotelById(String id);
}
