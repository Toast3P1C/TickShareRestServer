package com.tickShare.repositories;

import com.tickShare.entities.ITrip;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface TripRepository extends PagingAndSortingRepository<ITrip,Long> {
}
