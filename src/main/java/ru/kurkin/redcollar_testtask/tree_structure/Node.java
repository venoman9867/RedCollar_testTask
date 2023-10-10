package ru.kurkin.redcollar_testtask.tree_structure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    private String data;
    private Node leftNode;
    private Node rightNode;

    public Node(String data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }
    public boolean isQuestion() {
        return (leftNode != null) && (rightNode != null);
    }
}
