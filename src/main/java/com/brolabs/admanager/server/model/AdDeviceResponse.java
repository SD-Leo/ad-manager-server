package com.brolabs.admanager.server.model;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

/**
 * 2019-05-26
 *
 * @author Starovoytov Danil
 */
@Data
@Builder
public class AdDeviceResponse {

    private AdSettings settings;

    @Singular
    private List<Ad> ads;

}
