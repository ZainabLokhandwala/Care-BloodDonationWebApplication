package com.med.care.dao;


import com.med.care.domain.Receiver;
import com.med.care.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReceiverDAO extends JpaRepository<Receiver, String> {

    @Query(value = "from Receiver receiver where receiver.name like concat('%',:name,'%') or receiver.userName like concat('%',:userName,'%') or receiver.city like concat('%',:city,'%')")
    List<Receiver> searchByCityOrNameOrUserName(@Param("city") String city,@Param("userName") String userName,@Param("name") String name);
    @Query(value = "from Receiver receiver where receiver.name like concat('%',:name,'%') or receiver.userName like concat('%',:userName,'%') or receiver.bloodGroup like concat('%',:bloodGroup,'%')")
    List<Receiver> searchByBloodGroupOrNameOrUserName(@Param("bloodGroup")String bloodGroup,@Param("userName") String userName,@Param("name") String name);
    @Query(value = "from Receiver receiver where receiver.name like concat('%',:name,'%') or receiver.userName like concat('%',:userName,'%')")
    List<Receiver> searchByNameOrUserName(@Param("name")String name,@Param("userName") String userName);
}
