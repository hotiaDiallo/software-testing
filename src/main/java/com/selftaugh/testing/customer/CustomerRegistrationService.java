package com.selftaugh.testing.customer;

import com.selftaugh.testing.utils.PhoneNumberValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerRegistrationService {

    private final CustomerRepository customerRepository;
    private final PhoneNumberValidator phoneNumberValidator;

    public CustomerRegistrationService(CustomerRepository customerRepository, PhoneNumberValidator phoneNumberValidator) {
        this.customerRepository = customerRepository;
        this.phoneNumberValidator = phoneNumberValidator;
    }

    public void registerNewCustomer(CustomerRegistrationRequest request){

        Customer requestCustomer = request.getCustomer();
        String phoneNumber = requestCustomer.getPhoneNumber();

        if(!phoneNumberValidator.test(phoneNumber)){
            throw new IllegalStateException("Phone Number " +phoneNumber+ " is not valid");
        }

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
