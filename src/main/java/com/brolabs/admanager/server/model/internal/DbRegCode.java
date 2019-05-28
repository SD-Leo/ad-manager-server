package com.brolabs.admanager.server.model.internal;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * 2019-05-27
 *
 * @author Starovoytov Danil
 */
@Data
public class DbRegCode {

    @Id
    private String id;

    private String code;

    private String pointId;

    private LocalDateTime expired;

}
