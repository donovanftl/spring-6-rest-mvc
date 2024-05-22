package donovanftl.springframework.spring6restmvc.mappers;

import donovanftl.springframework.spring6restmvc.entities.Beer;
import donovanftl.springframework.spring6restmvc.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);

}
