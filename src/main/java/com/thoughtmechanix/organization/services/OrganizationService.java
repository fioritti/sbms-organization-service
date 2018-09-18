package com.thoughtmechanix.organization.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtmechanix.organization.model.Organization;
import com.thoughtmechanix.organization.repository.OrganizationRepository;

@Service
public class OrganizationService {
	
	@Autowired
	private OrganizationRepository orgRepository;
	
	public Iterable<Organization> getAllOrg(){
		return orgRepository.findAll();
	}
	
	public Organization getOrg(String organizationId) {
		return orgRepository.findById(organizationId);
	}
	
	public void saveOrg(Organization org) {
		org.setId(UUID.randomUUID().toString());
		orgRepository.save(org);
	}
	
	public void saveOrgWithID(Organization org) {
		orgRepository.save(org);
	}
	
	
	public void updateOrg(Organization org) {
		orgRepository.save(org);
	}
	
	public void deleteOrg(String orgId) {
		orgRepository.delete(orgId);
	}
	
	

}
