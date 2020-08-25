/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upperlink.jobboard.service;

import com.upperlink.jobboard.model.Application;
import com.upperlink.jobboard.repository.ApplicationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Terseer
 */
@Service
public class ApplicationServiceImpl implements ApplicationService{
    	@Autowired
	private ApplicationRepository applicationRepository;

	@Override
	public List<Application> getAllApplications() {
		return applicationRepository.findAll();
	}

	@Override
	public void saveApplication(Application application) {
            
		this.applicationRepository.save(application);
	}
        
        @Override
        public boolean checkApplicationLimit(){
          List applicants =  applicationRepository.findAll();
          return applicants.size() >= 4;
        }

    @Override
    public Application getApplicationById(long id) {
        Application applicants =  applicationRepository.getOne(id);
          return applicants;
    }
        
        
       

}
