package com.brolabs.admanager.server.service;

import com.brolabs.admanager.server.model.Organization;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class OrganizationService {

    private Map<String, Organization> database = new HashMap<>();

    @PostConstruct
    private void init() {
        Organization org1 = Organization
            .builder()
            .id("org-1")
            .name("Facebook")
            .ad("ad-1")
            .ad("ad-2")
            .build();

        database.put(org1.getId(), org1);
    }

    public Organization getOrganization(String id) {
        return database.get(id);
    }

    public List<Organization> getAllOrganizations() {
        return new ArrayList<>(database.values());
    }

    public Organization addOrganization(Organization organization) {
        organization.setId(UUID.randomUUID().toString());
        database.put(organization.getId(), organization);
        return organization;
    }

    public Organization updateOrganization(String id, Organization organization) {
        if (!database.containsKey(id)) {
            return null;
        }
        organization.setId(id);
        database.put(id, organization);
        return organization;
    }

    public Organization deleteOrganization(String id) {
        return database.remove(id);
    }
}
