package com.brolabs.admanager.server.controller;

import com.brolabs.admanager.server.exception.NotFoundOrganization;
import com.brolabs.admanager.server.model.Organization;
import com.brolabs.admanager.server.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;


    @GetMapping
    public List<Organization> getAllOrganizations() {
        return organizationService.getAllOrganizations();
    }

    @GetMapping("/{id}")
    public Organization getOrganization(@PathVariable String id) {
        Organization organization = organizationService.getOrganization(id);
        if (organization == null) {
            throw new NotFoundOrganization();
        }
        return organization;
    }

    @PostMapping
    public Organization addOrganization(@RequestBody Organization organization) {
        log.info("Add new organization: {}", organization);
        return organizationService.addOrganization(organization);
    }

    @PutMapping("/{id}")
    public Organization updateOrganization(@PathVariable String id, @RequestBody Organization organization) {
        log.info("Update organization: {} - {}", id, organization);
        Organization updateOrganization = organizationService.updateOrganization(id, organization);
        if (updateOrganization == null) {
            throw new NotFoundOrganization();
        }
        return updateOrganization;
    }

    @DeleteMapping("/{id}")
    public Organization deleteOrganization(@PathVariable String id) {
        log.info("Delete organization: {}", id);
        Organization deletedOrganization = organizationService.deleteOrganization(id);
        if (deletedOrganization == null) {
            log.info("Delete organization: {}", id);
            throw new NotFoundOrganization();
        }
        return deletedOrganization;
    }
}
