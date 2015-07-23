package com.med.care.dao;


import com.med.care.domain.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDonorDAO extends JpaRepository<Donor, String>{
}
