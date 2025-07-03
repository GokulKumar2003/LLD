package org.example;

import java.time.LocalDateTime;

public abstract class Node {

    protected String name;
    protected LocalDateTime createdAt;
    protected LocalDateTime lastModifiedAt;
    protected Node parent;

    public Node(String name, Directory parent){
        this.name = name;
        this.parent = parent;
        this.createdAt = LocalDateTime.now();
        this.lastModifiedAt = LocalDateTime.now();
        if(parent != null){
            parent.add(this);
        }
    }

    public String getName(){
        return name;
    }

    public void updateLastModifiedAt() {
        this.lastModifiedAt = LocalDateTime.now();
        if(parent != null){
            parent.updateLastModifiedAt();
        }
    }

    public abstract void print(String indent);
}
