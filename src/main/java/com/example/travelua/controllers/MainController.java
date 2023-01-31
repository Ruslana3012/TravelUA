package com.example.travelua.controllers;

import com.example.travelua.models.Travel;
import com.example.travelua.services.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final TravelService travelService;

    @PostMapping("/travels")
    public void addTravel(@RequestBody Travel travel) {
        travelService.saveNewTravel(travel);
    }

    @GetMapping("/travels")
    public List<Travel> showOfAllTravels() {
        return travelService.getAllTravels();
    }

    @GetMapping("/travels/by/date")
    public List<Travel> showOfAllTravelsByFromDate(@RequestParam(name = "date") String date) {
        return travelService.getAllTravelsByFromDate(date);
    }

    @GetMapping("/travels/by/date/to/date")
    public List<Travel> showOfAllTravelsByFromDateAndToDate(@RequestParam(name = "from_date") String fromDate,
                                                            @RequestParam(name = "to_date") String toDate) {
        return travelService.getAllTravelsByFromDateAndToDate(fromDate, toDate);
    }

    @GetMapping("/travels/by/city")
    public List<Travel> showOfAllTravelsByCity(@RequestParam(name = "city") String city) {
        return travelService.getAllTravelsByCity(city);
    }

    @DeleteMapping("/travels/date")
    public void removesAllTravelsByDate(@RequestParam(name = "date") String date) {
        travelService.deleteAllTravelsByFromDate(date);
    }

    @DeleteMapping("/travels/city")
    public void removesAllTravelsByCity(@RequestParam(name = "city") String city) {
        travelService.deleteAllTravelsByCity(city);
    }

    @PutMapping("/travels")
    public Travel putTravel(@RequestParam String name, @RequestBody Travel travel) {
        return travelService.updateTravel(name, travel);
    }

    @GetMapping("/convert")
    public double convertPriceOfTravelFromUAHToAnotherCurrency(@RequestParam(name = "currency") String currency,
                                                               @RequestParam(name = "amount") double amount) {
        return travelService.convertPriceFromUAHToAnotherCurrency(currency, amount);
    }
}
