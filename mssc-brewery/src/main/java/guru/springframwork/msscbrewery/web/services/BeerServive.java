package guru.springframwork.msscbrewery.web.services;


import guru.springframwork.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

   public interface BeerServive {
      BeerDto getByBeerId(UUID beerId);

      BeerDto savePost(BeerDto beerDto);

      void updateBeer(UUID beerId, BeerDto beerDto);
      void deleteBeer(UUID beerId);
   }
