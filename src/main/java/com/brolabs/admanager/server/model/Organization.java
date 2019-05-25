package com.brolabs.admanager.server.model;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class Organization {

    private String id;

    private String name;

    /**
     * Список рекламного материала из которого
     * организация может организовывать рекламные кампании
     */
    @Singular
    private List<String> ads;

    /**
     * Список рекламных кампаний
     */
    @Singular
    private List<String> campaigns;

}
