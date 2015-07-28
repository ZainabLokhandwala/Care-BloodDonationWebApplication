package com.med.care.dao;


import com.med.care.domain.Donor;
import com.med.care.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDonorDAO extends JpaRepository<Donor, String>{
    @Query(value = "from Donor donor where donor.name like concat('%',:name,'%') or donor.userName like concat('%',:userName,'%') or donor.city like concat('%',:city,'%')")
    List<Donor> searchByCityOrNameOrUserName(@Param("city")String city,@Param("userName") String userName,@Param("name") String name);
    @Query(value = "from Donor donor where donor.name like concat('%',:name,'%') or donor.userName like concat('%',:userName,'%') or donor.bloodGroup like concat('%',:bloodGroup,'%')")
    List<Donor> searchByBloodGroupOrNameOrUserName(@Param("bloodGroup")String bloodGroup,@Param("userName") String userName,@Param("name") String name);
    @Query(value = "from Donor donor where donor.name like concat('%',:name,'%') or donor.userName like concat('%',:userName,'%')")
    List<Donor> searchByNameOrUserName(@Param("name")String name,@Param("userName") String userName);
}
