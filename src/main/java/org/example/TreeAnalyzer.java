package org.example;

import java.util.List;

public class TreeAnalyzer {
    public static Tree findTreeWithMostLeaves(List<Tree> trees) throws Exception {
        int maxLeaves = 0;
        Tree treeWithMostLeaves = null;

        for (Tree tree : trees) {
            int leavesCount = tree.getAllLeaves().size();
            if (leavesCount > maxLeaves) {
                maxLeaves = leavesCount;
                treeWithMostLeaves = tree;
            } else if (leavesCount == maxLeaves) {
                throw new Exception("Multiple trees have the same maximum number of leaves.");
            }
        }

        return treeWithMostLeaves;
    }
}
