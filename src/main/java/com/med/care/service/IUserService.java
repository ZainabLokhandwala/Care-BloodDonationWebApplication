package com.med.care.service;

import com.med.care.domain.User;

import java.util.List;

public interface IUserService extends IService<User> {

    /**
     * This method handle search function
     * @param key keyword to search, coresponding to name and username
     * @param criteria additional criteria to search - by city or by blood group
     * @param criteriaValue criteria value to search, city name or blood group name, i.e AB
     * @return List of User contains search result
     */
    List<User> findUser(String key, String criteria, String criteriaValue);

    /**
     * find a user, either a donor or receiver
     * @param userName username
     * @return the user, either donor or receiver or null if not found
     */
    User findOne(String userName);
}
