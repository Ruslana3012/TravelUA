package com.example.travelua.repositories;

import com.example.travelua.models.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<Travel, String> {
    List<Travel> findByFromDate(String fromDate);

    List<Travel> findAllByFromDateAndToDate(String fromDate, String toDate);

    void deleteAllByFromDate(String fromDate);

    List<Travel> findAllByCity(String city);

    void deleteByCity(String city);

    Travel findByName(String name);
}
