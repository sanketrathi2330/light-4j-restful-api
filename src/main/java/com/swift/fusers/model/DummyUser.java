package com.swift.fusers.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>Copyright (c) 2020 Blue Yonder Group, Inc.
 * All Rights Reserved
 *
 * @author Sanket Rathi.
 */
public class DummyUser {
    private int id;
    private String name;
    private List<Integer> list;


    public DummyUser(int id, String name, List<Integer> list) {
        this.id = id;
        this.name = name;
        this.list = Collections.unmodifiableList(list);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "DummyUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                '}';
    }

    public static void main(String[] args) {
        int id = 1;
        String name = "tempUser";
        List<Integer> list = new ArrayList<>();
        list.add(1);
        DummyUser user = new DummyUser(id, name, list);
        user.setId(2);

        System.out.println(user.toString());
    }
}
