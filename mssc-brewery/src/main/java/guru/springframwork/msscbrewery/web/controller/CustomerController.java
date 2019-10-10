package guru.springframwork.msscbrewery.web.controller;


import guru.springframwork.msscbrewery.web.model.BeerDto;
import guru.springframwork.msscbrewery.web.model.CustomerDto;
import guru.springframwork.msscbrewery.web.services.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomerId(@PathVariable UUID customerId){

        return new ResponseEntity<>(customerService.getCustomerId(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto){

        CustomerDto customer = customerService.savePost(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/customer" + customerDto.getCustomerID().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping({"/{customerID}"})
    public ResponseEntity handlePut(@PathVariable  UUID customerID, @RequestBody CustomerDto customerDto ){

        customerService.handlePut(customerID,customerDto);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable  UUID customerId){
        customerService.deleteCustomer(customerId);

    }




}
