package com.example.week5day1.Controller;


import com.example.week5day1.Model.Customer;
import com.example.week5day1.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {


    private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity getAllCustomer(){
        return ResponseEntity.status(200).body(customerService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody Customer customer){
    customerService.addCustomer(customer);
    return ResponseEntity.status(200).body("Customer added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody Customer customer, @PathVariable Integer id){
        customerService.updateCustomer(id,customer);
        return ResponseEntity.status(200).body("Customer Updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("Customer deleted");
    }
}