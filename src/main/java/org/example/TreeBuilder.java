package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeBuilder {
    public static List<Tree> buildTreesFromCSV(String filename) throws IOException {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int nodeId = Integer.parseInt(parts[0].trim());
                int parentId = Integer.parseInt(parts[1].trim());

                TreeNode node = nodes.computeIfAbsent(nodeId, TreeNode::new);
                if (nodeId != parentId) {
                    TreeNode parent = nodes.computeIfAbsent(parentId, TreeNode::new);
                    parent.addChild(node);
                }
            }
        }

        List<Tree> trees = new ArrayList<>();
        for (TreeNode node : nodes.values()) {
            if (node.isRoot()) {
                trees.add(new Tree(node));
            }
        }
        return trees;
    }
}
