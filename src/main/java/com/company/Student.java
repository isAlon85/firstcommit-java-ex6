package com.company;

import java.util.ArrayList;

public class Student {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String country;
    private String location;
    private boolean transfer;
    private boolean remote;
    private Picture picture;
    private Resume resume;
    private ArrayList<Tag> tags;

    public Student() {
    }

    public Student(Long id, String name, String email, String phone, String country, String location, boolean transfer, boolean remote) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.location = location;
        this.transfer = transfer;
        this.remote = remote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isTransfer() {
        return transfer;
    }

    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                ", location='" + location + '\'' +
                ", transfer=" + transfer +
                ", remote=" + remote +
                ", picture=" + picture +
                ", resume=" + resume +
                ", tags=" + tags +
                '}';
    }

}
