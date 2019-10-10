package guru.springframwork.msscbrewery.web.services;

import guru.springframwork.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Slf4j
public class BeerServiveImpl implements BeerServive {

    @Override
    public BeerDto getByBeerId(UUID beerId) {
        return  BeerDto.builder().beerId(UUID.randomUUID())
                .beerName("BlueMoon")
                .beerStyle("Draft")
                .build();
    }

    @Override
    public BeerDto savePost(BeerDto beerDto) {
        return beerDto.builder().beerId(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {

    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Deleting a beer.....");


    }
}
