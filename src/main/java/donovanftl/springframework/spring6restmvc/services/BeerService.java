package donovanftl.springframework.spring6restmvc.services;

import donovanftl.springframework.spring6restmvc.entities.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    List<Beer> listBeers();

    Beer getBeerById(UUID id);

    Beer saveNewBeer(Beer beer);
}
