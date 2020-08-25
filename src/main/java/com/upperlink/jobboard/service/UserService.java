/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upperlink.jobboard.service;

import com.upperlink.jobboard.dao.UserRegistrationDao;
import com.upperlink.jobboard.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Terseer
 */
public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDao registration);
}
 
