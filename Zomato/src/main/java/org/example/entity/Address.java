package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Address {
    private String location;
    private String flatNo;
    private String streetName;
    private String area;
    String city;
    private Long pincode;
}
