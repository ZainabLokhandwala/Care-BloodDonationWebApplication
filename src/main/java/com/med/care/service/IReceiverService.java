package com.med.care.service;


import com.med.care.domain.Receiver;
import com.med.care.domain.User;

import java.util.List;

public interface IReceiverService extends IService<Receiver> {

    /**
     * This method handle search function
     * @param key keyword to search, coresponding to name and username
     * @param criteria additional criteria to search - by city or by blood group
     * @param criteriaValue criteria value to search, city name or blood group name, i.e AB
     * @return List of Receiver contains search result
     */
    List<Receiver> findUser(String key, String criteria, String criteriaValue);
}
