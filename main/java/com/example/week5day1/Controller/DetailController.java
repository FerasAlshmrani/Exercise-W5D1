package com.example.week5day1.Controller;

import com.example.week5day1.DTO.CustomerDTO;
import com.example.week5day1.Model.Details;
import com.example.week5day1.Service.DetailsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/details")
public class DetailController {

    private final DetailsService detailsService;

    @GetMapping("/get")
    public ResponseEntity getDetail(){
        return ResponseEntity.status(200).body(detailsService.getDetails());
    }


    @PostMapping("/add")
    public ResponseEntity addDetail(@RequestBody @Valid CustomerDTO customerDTO){
        detailsService.addDetails(customerDTO);
        return ResponseEntity.status(200).body("detail added");
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateDetail(@RequestBody @Valid CustomerDTO customerDTO, @PathVariable Integer id){
        detailsService.updateDetail(customerDTO,id);
        return ResponseEntity.status(200).body("detail updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDetail( @PathVariable Integer id){
        detailsService.deleteDetail(id);
        return ResponseEntity.status(200).body("detail deleted");
    }

}
