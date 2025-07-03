package org.example;

import java.sql.SQLOutput;

public class File extends Node{

    private String content;

    public File(String name, Directory parent){
        super(name, parent);
    }

    public void write(String content){
        this.content += content;
        updateLastModifiedAt();
    }

    public void print(String indent){
        System.out.print(indent + "File: " + name);
        System.out.print(" | Created At: "  + createdAt);
        System.out.print(" | Last Modified: " + lastModifiedAt);
        System.out.println();
    }
}
