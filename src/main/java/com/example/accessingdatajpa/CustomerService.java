package com.example.accessingdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void SaveTest() {
        SaveIfNotExists(new Customer("David", "Lee"));
        SaveIfNotExists(new Customer("David", "Lee2"));
        SaveIfNotExists(new Customer("Dd", "Lee"));
    }

    @Transactional(propagation = Propagation.NESTED)
    private  void SaveIfNotExists(Customer customer) {
        try {
            customerRepository.save(customer);
        }
        catch(Exception e){}
    }
}
