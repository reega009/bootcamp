package com.bootcamptdi.tutorial.dto;

import com.bootcamptdi.tutorial.entity.Produsen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProdukDTO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class New {
        @NotNull
        @NotEmpty
        private String nama;
        @NotNull
        @NotEmpty
        private String jenis;
        @NotNull
        private Integer berat;
        @NotNull
        private Integer produsen;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update{
        @NotNull
        private Integer id;
        @NotNull
        @NotEmpty
        private String nama;
        @NotNull
        @NotEmpty
        private String jenis;
        @NotNull
        private Integer berat;
        @NotNull
        private Integer produsen;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProdukProdusen{
        private Integer produkId;
        private String produkNama;
        private String produkJenis;
        private Integer produkBerat;
        private Integer produsenId;
        private String produsenNama;
        private String produsenKode;
        private String produsenAlamat;
    }
}
