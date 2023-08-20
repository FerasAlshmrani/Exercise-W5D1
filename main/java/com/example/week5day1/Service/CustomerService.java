package com.example.week5day1.Service;

import com.example.week5day1.ApiResponse.ApiException;
import com.example.week5day1.Model.Customer;
import com.example.week5day1.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer id , Customer customer){
        Customer customer1 = customerRepository.findCustomerById(id);


        if(customer1 == null){

            throw new ApiException("Customer not found");
        }
        customer1.setName(customer.getName());
        customer1.setDetails(customer.getDetails());
        customerRepository.save(customer1);
    }

    public void deleteCustomer(Integer id) {
        Customer customer1 = customerRepository.findCustomerById(id);

        if (customer1 == null) {

            throw new ApiException("Customer not found");
        }
        customerRepository.delete(customer1);
    }
}
