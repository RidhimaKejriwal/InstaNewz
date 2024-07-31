package com.instanews.instanewz.entities;

public class Source {
    private String id;
    private String name;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Source() {
    }
    @Override
    public String toString() {
        return "Source [id=" + id + ", name=" + name + "]";
    }
    public Source(String id, String name) {
        this.id = id;
        this.name = name;
    }

    
}
