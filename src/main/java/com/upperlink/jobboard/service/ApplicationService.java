/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upperlink.jobboard.service;

import com.upperlink.jobboard.model.Application;
import java.util.List;

/**
 *
 * @author Terseer
 */
public interface ApplicationService {
    	List<Application> getAllApplications();
	void saveApplication(Application application);
 	boolean checkApplicationLimit();
        Application getApplicationById(long id);
 
 
}
