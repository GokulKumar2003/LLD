package org.example;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Node{

    List<Node> nodes = new ArrayList<>();

    public Directory(String name, Directory parent){

        super(name, parent);
    }

    public void add(Node node){
        nodes.add(node);
    }

    public void print(String indent){
        System.out.print(indent + "Dir: " + name);
        System.out.print(" | Created At: "  + createdAt);
        System.out.print(" | Last Modified: " + lastModifiedAt);
        System.out.println();
        for(Node node : nodes){
            node.print(indent + "    ");
        }
    }
}
