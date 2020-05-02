package com.tickShare.controllers;

import com.tickShare.entities.ITrip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.tickShare.repositories.TripRepository;

@RestController
public class TripController {
    private final TripRepository tripRepository;

    @Autowired
    public TripController(TripRepository tripRepository){
        this.tripRepository = tripRepository;
    }

    @GetMapping("/users/{id}")
    public ITrip findUserById(@PathVariable("id") ITrip trip) {
        return trip;
    }

    @GetMapping("/users")
    public Page<ITrip> findAllUsers(Pageable pageable) {
        return tripRepository.findAll(pageable);
    }

    @GetMapping("/sortedusers")
    public Page<ITrip> findAllUsersSortedByName() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by("name"));
        return tripRepository.findAll(pageable);
    }

}
