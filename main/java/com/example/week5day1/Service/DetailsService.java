package com.example.week5day1.Service;

import com.example.week5day1.ApiResponse.ApiException;
import com.example.week5day1.DTO.CustomerDTO;
import com.example.week5day1.Model.Customer;
import com.example.week5day1.Model.Details;
import com.example.week5day1.Repository.CustomerRepository;
import com.example.week5day1.Repository.DetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailsService {


    private final CustomerRepository customerRepository;
    private final DetailRepository detailRepository;

    public List<Details> getDetails(){
        return detailRepository.findAll();
    }

    public void addDetails(CustomerDTO customerDTO){
        Customer customer = customerRepository.findCustomerById(customerDTO.getCustomer_id());
        if(customer == null){
            throw new ApiException("wrong customerID");
        }
        Details details = new Details(null,customerDTO.getGender(),customerDTO.getAge(),customerDTO.getEmail(),customer);

        detailRepository.save(details);
    }

    public void updateDetail(CustomerDTO customerDTO,Integer id){
        Details detail = detailRepository.getDetailsById(id);
        Customer customer = customerRepository.findCustomerById(customerDTO.getCustomer_id());

        if(detail == null){
            throw new ApiException("Wrong detailID");
        }
        if(customerDTO == null){
            throw new ApiException("Wrong CustomerID");
        }
        detail.setAge(customerDTO.getAge());
        detail.setCustomer(customer);
        detail.setEmail(customerDTO.getEmail());
        detail.setGender(customerDTO.getGender());

        detailRepository.save(detail);
    }

    public void deleteDetail(Integer id){
        Details details = detailRepository.getDetailsById(id);

        if(details == null ){
            throw new ApiException("wrong detailsID");
        }
        CustomerDTO customerDTO = new CustomerDTO(details.getCustomer().getId(),details.getGender(),details.getAge(),details.getEmail());
        Customer customer = customerRepository.findCustomerById(customerDTO.getCustomer_id());
        if(customer.getDetails() == null){
            throw new ApiException("this customerID dont have details to delete");
        }

        customer.setDetails(null);
        customerRepository.save(customer);
        detailRepository.delete(details);
    }



}
