package com.brolabs.admanager.server.controller;

import com.brolabs.admanager.server.model.UploadFileResponse;
import com.brolabs.admanager.server.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 2019-05-21
 *
 * @author Starovoytov Danil
 */
@RestController
@RequestMapping("/api/upload")
public class UploadController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping
    public UploadFileResponse uploadContent(@RequestParam MultipartFile file) {
        return fileStorageService.saveFile(file);
    }
}
