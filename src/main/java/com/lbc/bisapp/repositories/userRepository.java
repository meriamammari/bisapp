package com.lbc.bisapp.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lbc.bisapp.entities.User;

@Repository
public interface userRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.subDepartment.name = :subDepartmentName")
    List<User> findUserBySubDepartmentName(@Param("subDepartmentName") String subDepartmentName);
}

