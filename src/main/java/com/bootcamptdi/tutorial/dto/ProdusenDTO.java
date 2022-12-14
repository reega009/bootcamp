package com.bootcamptdi.tutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProdusenDTO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Save{
        @NotNull
        @NotEmpty
        private String name;
        @NotNull
        @NotEmpty
        @Size(min = 5, max = 8)
        private String kode;
        @NotNull
        @NotEmpty
        private String alamat;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update{
        @NotNull
        private Integer id;
        @NotNull
        @NotEmpty
        private String name;
        @NotNull
        @NotEmpty
        @Size(min = 5, max = 8)
        private String kode;
        @NotNull
        @NotEmpty
        private String alamat;
    }
}
