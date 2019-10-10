package guru.springframwork.msscbrewery.web.services;

import guru.springframwork.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;



@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerId(UUID customerId) {

        return  CustomerDto.builder()
                .customerID(UUID.randomUUID())
                .customerName("Neeraj")
                .build();
    }

    @Override
    public CustomerDto savePost(CustomerDto customerDto) {
        return  customerDto.builder()
                .customerID(UUID.randomUUID()).build();
    }

    @Override
    public void handlePut(UUID customerID, CustomerDto customerDto) {

    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("deleting customer.....");
    }

}
