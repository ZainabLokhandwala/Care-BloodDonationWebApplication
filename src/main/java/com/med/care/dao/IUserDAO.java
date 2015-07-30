package com.med.care.dao;


import com.med.care.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserDAO extends JpaRepository<User, String>{

    List<User> findByCityAndNameAndUserName (String city, String userName, String name);
    List<User> findByBloodGroupAndNameAndUserName (String bloodGroup, String userName, String name);
    List<User> findByNameAndUserName(String name, String userName);
    @Query("select receivedMessages from User u where u.id=:id")
    List<User> findInboxedUser(@Param("id")String id);
}
