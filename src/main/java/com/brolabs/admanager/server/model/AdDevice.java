package com.brolabs.admanager.server.model;

import lombok.Builder;
import lombok.Data;

/**
 * 2019-05-25
 *
 * @author Starovoytov Danil
 */
@Data
@Builder
public class AdDevice {

    private String id;

    private String token;

}
