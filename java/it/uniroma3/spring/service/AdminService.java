package it.uniroma3.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Admin;
import it.uniroma3.spring.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository; 

    public Iterable<Admin> findAll() {
        return this.adminRepository.findAll();
    }
    
    @Transactional
    public void add(final Admin admin) throws Exception{
        this.adminRepository.save(admin);    	
    }
    
    public Admin find(final Long id) {
    	return this.adminRepository.findOne(id);
    }
    
    public Admin findByUsername(String username){
    	return (Admin) this.adminRepository.findByUsername(username);
    }

	public Admin save(Admin admin) {
		return this.adminRepository.save(admin);
	}


}