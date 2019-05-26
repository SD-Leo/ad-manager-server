package com.brolabs.admanager.server.model;

import lombok.Builder;
import lombok.Data;


/**
 * Точка показа рекламы
 */
@Data
@Builder
public class AdPoint {

    private String token;

    private String name;

}
