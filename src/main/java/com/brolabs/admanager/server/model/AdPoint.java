package com.brolabs.admanager.server.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;


/**
 * Точка показа рекламы
 */
@Data
@Builder
public class AdPoint {

    @Id
    private String id;

    private String token;

    private String name;

}
