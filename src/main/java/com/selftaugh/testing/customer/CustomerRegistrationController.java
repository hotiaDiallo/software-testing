package com.selftaugh.testing.customer;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/customer-registration")
public class CustomerRegistrationController {

    public void registerNewCustpmer(@Valid @RequestBody CustomerRegistrationRequest request){

    }
}
