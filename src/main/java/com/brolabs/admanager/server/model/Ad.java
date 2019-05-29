package com.brolabs.admanager.server.model;

import lombok.Builder;
import lombok.Data;


/**
 * Рекламный материал
 */
@Data
@Builder
public class Ad {

    private String id;

    private AdType type;

    private String url;

    private AdSettings settings;

}
