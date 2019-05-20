package com.brolabs.admanager.server.model;

import lombok.Data;

@Data
public class Ad {

    private String id;

    private AdType type;

    private String url;

    private AdSettings settings;

}
