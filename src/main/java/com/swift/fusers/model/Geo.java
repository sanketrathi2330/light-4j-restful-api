package com.swift.fusers.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.mongodb.morphia.annotations.Embedded;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Embedded
public class Geo {
        private String lat = "";
        private String lng = "";

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }
    }