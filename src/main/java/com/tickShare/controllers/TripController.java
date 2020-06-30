package com.tickShare.controllers;

import com.tickShare.entities.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tickShare.repositories.TripRepository;

import java.util.List;
import java.util.Optional;


@RestController
public class TripController {
    private final TripRepository tripRepository;

    @Autowired
    public TripController(TripRepository tripRepository){
        this.tripRepository = tripRepository;
    }

    @GetMapping("/trips")
    public List<Trip> findAllTrips()  {
        return tripRepository.findAll();
    }

    @GetMapping("/trip/{id}")
    public Optional<Trip> findTripById(@PathVariable("id") Long id) {
        return tripRepository.findById(id);
    }
    
    @PostMapping("/trip")
    public Trip createNewTrip(@RequestBody Trip trip){
        return tripRepository.save(trip);
    }

    @PutMapping("/trip/{id}")
    public Trip replaceTrip(@RequestBody Trip newTrip, @PathVariable Long id){
        return tripRepository.findById(id)
                .map(trip -> {
                    trip.setStartingLocation(newTrip.getStartingLocation());
                    trip.setDestination(newTrip.getDestination());
                    trip.setStartingTime(newTrip.getStartingTime());
                    trip.setSeatsLeft(newTrip.getSeatsLeft());
                    trip.setUserToken(newTrip.getUserToken());
                    return tripRepository.save(trip);
                })
                .orElseGet(()->{
                        newTrip.setId(id);
                        return tripRepository.save(newTrip);
                });
    }
    @DeleteMapping("trip/{id}")
    public void deleteTrip(@PathVariable Long id){
        tripRepository.deleteById(id);
    }

}
