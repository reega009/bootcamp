package com.bootcamptdi.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produsen {
    private Integer id;
    private String name;
    private String kode;
    private String alamat;
}
