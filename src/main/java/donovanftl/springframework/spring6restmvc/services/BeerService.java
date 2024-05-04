package donovanftl.springframework.spring6restmvc.services;

import donovanftl.springframework.spring6restmvc.entities.Beer;

import java.util.UUID;

public interface BeerService {

    Beer getBeerById(UUID id);
}
