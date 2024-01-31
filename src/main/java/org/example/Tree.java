package org.example;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private final TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public List<TreeNode> getAllNodes() {
        List<TreeNode> allTreeNodes = new ArrayList<>();
        addNodeAndDescendants(root, allTreeNodes);
        return allTreeNodes;
    }

    private void addNodeAndDescendants(TreeNode treeNode, List<TreeNode> treeNodeList) {
        treeNodeList.add(treeNode);
        for (TreeNode child : treeNode.getChildren()) {
            addNodeAndDescendants(child, treeNodeList);
        }
    }

    public List<TreeNode> getAllLeaves() {
        List<TreeNode> leaves = new ArrayList<>();
        findLeaves(root, leaves);
        return leaves;
    }

    private void findLeaves(TreeNode treeNode, List<TreeNode> leaves) {
        if (treeNode.isLeaf()) {
            leaves.add(treeNode);
        } else {
            for (TreeNode child : treeNode.getChildren()) {
                findLeaves(child, leaves);
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb, "\n", "");
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb, String prefix, String childrenPrefix) {
        if (node != null) {
            sb.append(prefix);
            sb.append(node.getId());
            sb.append('\n');
            for (int i = 0; i < node.getChildren().size(); i++) {
                TreeNode next = node.getChildren().get(i);
                if (i < node.getChildren().size() - 1) {
                    buildString(next, sb, childrenPrefix + "├── ", childrenPrefix + "│   ");
                } else {
                    buildString(next, sb, childrenPrefix + "└── ", childrenPrefix + "    ");
                }
            }
        }
    }

//    @Override
//    public String toString() {
//        List<TreeNode> allNodes = getAllNodes();
//        StringBuilder sb = new StringBuilder();
//        for (TreeNode node : allNodes) {
//            sb.append("Node ID: ").append(node.getId());
//            if (!node.isRoot()) {
//                sb.append(", Parent ID: ").append(node.getParent().getId());
//            }
//            sb.append('\n');
//        }
//        return sb.toString();
//    }

//@Override
//public String toString() {
//    StringBuilder stringBuilder = new StringBuilder();
//    for (TreeNode node : getAllNodes()) {
//        stringBuilder.append("(").append(node.getId());
//        if (node.getParent() != null) {
//            stringBuilder.append(", ").append(node.getParent().getId());
//        } else {
//            stringBuilder.append(", ").append(node.getId()); // Or some other representation for the root
//        }
//        stringBuilder.append(") ");
//    }
//    String result = stringBuilder.toString();
//    return result;
//}

}
