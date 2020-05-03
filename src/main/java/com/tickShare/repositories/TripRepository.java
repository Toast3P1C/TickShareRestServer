package com.tickShare.repositories;

import com.tickShare.entities.Trip;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TripRepository extends PagingAndSortingRepository<Trip,Long> {
}
