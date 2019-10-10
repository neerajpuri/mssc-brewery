package guru.springframwork.msscbrewery.web.services;


import guru.springframwork.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface CustomerService {

    CustomerDto getCustomerId(UUID customerId);

    CustomerDto savePost(CustomerDto customerDto);

    void handlePut(UUID customerID, CustomerDto customerDto);

    void deleteCustomer(UUID customerId);
}
