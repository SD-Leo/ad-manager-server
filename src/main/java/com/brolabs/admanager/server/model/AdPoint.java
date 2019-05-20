package com.brolabs.admanager.server.model;

import lombok.Data;

import java.util.List;


@Data
public class AdPoint {

    private String id;

    private String name;

    private String organizationId;

    private List<Ad> ads;

}
