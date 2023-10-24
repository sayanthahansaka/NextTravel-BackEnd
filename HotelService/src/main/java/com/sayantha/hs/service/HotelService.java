package com.sayantha.hs.service;

import com.sayantha.hs.dto.HotelDTO;

import java.util.List;

public interface HotelService {
    HotelDTO saveHotel(HotelDTO hotelDTO);
    HotelDTO updateHotel(HotelDTO hotelDTO);
    void deleteHotelByID(Integer id);
//    HotelDTO searchHotelByName(String name);
    List<HotelDTO> getAllHotel();
    HotelDTO searchHotelByID(Integer id);

}
