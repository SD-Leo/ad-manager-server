package com.brolabs.admanager.server.model;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;


@Data
@Builder
public class AdPoint {

    private String id;

    private String name;

    private String organizationId;

    @Singular
    private List<String> ads;

}
