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
public class Company {
    private String name = "";
    private String catchPhrase = "";
    private String bs = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
}
