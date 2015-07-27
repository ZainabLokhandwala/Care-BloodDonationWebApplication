package com.med.care.dao;


import com.med.care.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDAO extends JpaRepository<User, String>{
}
