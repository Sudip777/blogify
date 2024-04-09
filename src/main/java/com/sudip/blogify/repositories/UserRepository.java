package com.sudip.blogify.repositories;

import com.sudip.blogify.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {


    void delete(Users users);
}