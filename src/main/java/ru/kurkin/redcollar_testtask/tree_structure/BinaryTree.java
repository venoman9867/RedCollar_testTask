package ru.kurkin.redcollar_testtask.tree_structure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinaryTree {
    private final String initQ="Это животное живет на суше?";
    private String[] initA={"кот","кит"};
    private final Node root;
    private Node current;

    public BinaryTree() {
        root = new Node(initQ);
        root.setLeftNode(new Node(initA[0]));
        root.setRightNode(new Node(initA[1]));
        current=root;
    }

}
