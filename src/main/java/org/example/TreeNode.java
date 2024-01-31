package org.example;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private final int id;
    private final List<TreeNode> children;
    private TreeNode parent;

    public TreeNode(int id) {
        this.id = id;
        this.children = new ArrayList<>();
        this.parent = null;
    }

    public int getId() {
        return id;
    }

    public TreeNode getParent() {
        return parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void addChild(TreeNode child) {
        child.parent = this;
        children.add(child);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public boolean isRoot() {
        return parent == null;
    }
}
