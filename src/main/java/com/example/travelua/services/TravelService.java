package com.example.travelua.services;

import com.example.travelua.models.Travel;
import com.example.travelua.repositories.TravelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TravelService {
    private final TravelRepository travelRepository;

    public void saveNewTravel(Travel travel) {
        travelRepository.save(travel);
    }

    public List<Travel> getAllTravels() {
        return travelRepository.findAll();
    }

    public List<Travel> getAllTravelsByFromDate(String date) {
        return travelRepository.findByFromDate(date);
    }

    public void deleteAllTravelsByFromDate(String date) {
        travelRepository.deleteAllByFromDate(date);
    }

    public List<Travel> getAllTravelsByFromDateAndToDate(String fromDate, String toDate) {
        return travelRepository.findAllByFromDateAndToDate(fromDate, toDate);
    }

    public List<Travel> getAllTravelsByCity(String city) {
        return travelRepository.findAllByCity(city);
    }

    public void deleteAllTravelsByCity(String city) {
        travelRepository.deleteByCity(city);
    }

    public Travel updateTravel(String name, Travel updateTravel) {
        Travel newTravel = travelRepository.findByName(name);
        if (updateTravel.getCity() != null) newTravel.setCity(updateTravel.getCity());
        if (updateTravel.getName() != null) newTravel.setName(updateTravel.getName());
        if (updateTravel.getFromDate() != null) newTravel.setFromDate(updateTravel.getFromDate());
        if (updateTravel.getToDate() != null) newTravel.setToDate(updateTravel.getToDate());
        if (updateTravel.getPrice() != null) newTravel.setPrice(updateTravel.getPrice());
        if (updateTravel.getDescription() != null) newTravel.setDescription(updateTravel.getDescription());

        return travelRepository.save(newTravel);
    }
}
