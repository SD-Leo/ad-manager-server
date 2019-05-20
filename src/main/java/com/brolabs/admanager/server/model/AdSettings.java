package com.brolabs.admanager.server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AdSettings {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateStart;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateEnd;

}
