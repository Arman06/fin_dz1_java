package org.example;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Tree> trees = TreeBuilder.buildTreesFromCSV("input.csv");
            System.out.println(trees);

            Tree tree = TreeAnalyzer.findTreeWithMostLeaves(trees);

            int treeId = tree != null ? tree.getRoot().getId() : 0;
            int leavesCount = tree != null ? tree.getAllLeaves().size() : 0;

            writeToCSV("output.csv", treeId, leavesCount);
        } catch (Exception e) {
            System.out.println(e);
            writeToCSV("output.csv", 0, 0);
        }
    }

    private static void writeToCSV(String filename, int treeId, int leavesCount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(treeId + "," + leavesCount);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            BufferedWriter wr = new BufferedWriter(new FileWriter("testfile.txt"));
//            wr.write("bik chungus");
//            wr.write("\nsmol chungus");
//            wr.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

}

