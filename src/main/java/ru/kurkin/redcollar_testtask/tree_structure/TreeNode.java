package ru.kurkin.redcollar_testtask.tree_structure;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@Getter
public class TreeNode {

    private String value;
    private List<TreeNode> childNodes;

    public TreeNode(String value) {
        this.value = value;
        this.childNodes = new LinkedList<>();
    }

    public void addChild(TreeNode childNode) {
        this.childNodes.add(childNode);
    }

    public void showTreeNodes() {
        PassingThroughNodes.printNodes(this);
    }

}
