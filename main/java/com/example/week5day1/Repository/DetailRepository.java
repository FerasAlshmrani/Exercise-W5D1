package com.example.week5day1.Repository;

import com.example.week5day1.Model.Details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepository extends JpaRepository<Details,Integer> {
    Details getDetailsById(Integer id);
}
