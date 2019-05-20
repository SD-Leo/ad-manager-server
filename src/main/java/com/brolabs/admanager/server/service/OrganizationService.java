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
        Organization organization = new Organization();
        organization.setId("111");
        organization.setName("Google");
        database.put(organization.getId(), organization);

        organization = new Organization();
        organization.setId("222");
        organization.setName("Facebook");
        database.put(organization.getId(), organization);

        organization = new Organization();
        organization.setId("333");
        organization.setName("Amazon");
        database.put(organization.getId(), organization);

        organization = new Organization();
        organization.setId("444");
        organization.setName("Apple");
        database.put(organization.getId(), organization);

//
//        10e31f32-20cc-4df4-94fe-0e3b3eac31c0
//        9a28bcb8-9e02-471c-9d40-70c57ec57bcf
//        System.out.println(UUID.randomUUID().toString());
    }


    public List<Organization> getAllOrganizations() {
        return new ArrayList<>(database.values());
    }

    public Organization getOrganization(String id) {
        return database.get(id);
    }

    public Organization addOrganization(Organization organization) {
        String id = UUID.randomUUID().toString();
        organization.setId(id);
        database.put(id, organization);
        return organization;
    }

    public Organization deleteOrganization(String id) {
        return database.remove(id);
    }


    public Organization updateOrganization(String id, Organization organization) {
        if (!database.containsKey(id)) {
            return null;
        }
        organization.setId(id);
        database.put(id, organization);
        return organization;
    }
}
