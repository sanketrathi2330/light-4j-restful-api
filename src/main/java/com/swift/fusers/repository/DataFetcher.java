package com.swift.fusers.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swift.fusers.model.User;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

public class DataFetcher {
 
    public List<User> getUsersFromPlaceHolder() {
        List<User> usrPost = Collections.emptyList();

        ObjectMapper mapper = new ObjectMapper();
        try {
            usrPost = mapper.readValue(new URL("http://jsonplaceholder.typicode.com/users"), new TypeReference<>() {});
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return usrPost;
    }
}