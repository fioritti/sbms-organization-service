package com.thoughtmechanix.organization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtmechanix.organization.model.Organization;
import com.thoughtmechanix.organization.services.OrganizationService;

@RestController
@RequestMapping(value = "v1/organizations")
public class OrganizationServiceController {

	@Autowired
	private OrganizationService orgService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<Organization> getOrganization() {
		return orgService.getAllOrg();
	}
	
	@RequestMapping(value = "/{organizationId}", method = RequestMethod.GET)
	public Organization getOrganization(@PathVariable("organizationId") String organizationId) {
		System.out.println("get Organization ID : " + organizationId);
		return orgService.getOrg(organizationId);
	}

	@RequestMapping(value = "/{organizationId}", method = RequestMethod.PUT)
	public void updateOrganization(@PathVariable("organizationId") String organizationId,
			@RequestBody Organization org) {
		orgService.updateOrg(org);
	}

	@RequestMapping(value = "/{organizationId}", method = RequestMethod.POST)
	public void saveOrganization(@RequestBody Organization org) {
		orgService.saveOrg(org);
	}

	@RequestMapping(value = "/{organizationId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOrganization(@PathVariable("organizationId") String organizationId,
			@RequestBody Organization org) {
		orgService.deleteOrg(org);
	}

}