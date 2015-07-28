package com.med.care.service;


import com.med.care.domain.Donor;
import com.med.care.domain.User;

import java.util.List;

public interface IDonorService extends IService<Donor> {

    /**
     * This method handle search function
     * @param key keyword to search, coresponding to name and username
     * @param criteria additional criteria to search - by city or by blood group
     * @param criteriaValue criteria value to search, city name or blood group name, i.e AB
     * @return List of Donor contains search result
     */
    List<Donor> findUser(String key, String criteria, String criteriaValue);
}
