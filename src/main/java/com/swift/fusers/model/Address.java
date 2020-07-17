package com.swift.fusers.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.mongodb.morphia.annotations.Embedded;

/**
 * <p>Copyright (c) 2020 Blue Yonder Group, Inc.
 * All Rights Reserved
 *
 * @author Sanket Rathi.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Embedded
public class Address {
    private String street = "";
    private String suite = "";
    private String city = "";
    private String zipcode = "";
    @Embedded
    private Geo geo = new Geo();

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
