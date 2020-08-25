/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upperlink.jobboard.repository;

import com.upperlink.jobboard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Terseer
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
