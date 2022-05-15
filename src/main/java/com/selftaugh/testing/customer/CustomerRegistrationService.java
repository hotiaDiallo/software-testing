package com.selftaugh.testing.customer;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerRegistrationService {

    private final CustomerRepository customerRepository;

    public CustomerRegistrationService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void registerNewCustomer(CustomerRegistrationRequest request){

        Customer requestCustomer = request.getCustomer();
        String phoneNumber = requestCustomer.getPhoneNumber();

        Optional<Customer> optionalCustomer = customerRepository.selectCustomerByPhoneNumber(phoneNumber);

        if(optionalCustomer.isPresent()){
            Customer customer = optionalCustomer.get();
            if(customer.getName().equals(requestCustomer.getName())){
                return;
            }
            throw new IllegalStateException(String.format("phone number [%s] is taken", phoneNumber));
        }
        if(requestCustomer.getId()==null){
            requestCustomer.setId(UUID.randomUUID());
        }
        customerRepository.save(requestCustomer);
    }
}
