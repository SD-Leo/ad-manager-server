package com.brolabs.admanager.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 2019-05-21
 *
 * @author Starovoytov Danil
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadFileResponse {

    private String fileName;

    private String fileType;

    private long size;

    private String message;

}
