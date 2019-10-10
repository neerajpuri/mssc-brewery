package guru.springframwork.msscbrewery.web.controller;


import guru.springframwork.msscbrewery.web.model.BeerDto;
import guru.springframwork.msscbrewery.web.services.BeerServive;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerServive beerServive;

    public BeerController(BeerServive beerServive) {
        this.beerServive = beerServive;
    }


    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable  UUID beerId){
        return new ResponseEntity<>(beerServive.getByBeerId(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDto beerDto){

        BeerDto beer= beerServive.savePost(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location" ,"/api/v1/beer"  + beer.getBeerId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity putMapping(@PathVariable UUID beerId, @RequestBody  BeerDto beerDto){
        beerServive.updateBeer(beerId,beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable  UUID beerId){
        beerServive.deleteBeer(beerId);

    }

}
