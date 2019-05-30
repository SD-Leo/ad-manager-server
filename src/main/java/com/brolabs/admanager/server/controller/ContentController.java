package com.brolabs.admanager.server.controller;

import com.brolabs.admanager.server.exception.NotFoundAdException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 2019-05-30
 *
 * @author Starovoytov Danil
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class ContentController {

    @GetMapping(value = "/content/{filename}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] download(@PathVariable String filename) throws IOException {

        File file = new File("content/" + filename);
        if (!file.exists()) {
            throw new NotFoundAdException("File not found: " + filename);
        }
        FileInputStream in = new FileInputStream(file);
        byte[] arr = new byte[in.available()];
        in.read(arr);

        return arr;
    }

}
