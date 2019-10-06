package com.company;

import java.util.HashSet;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet();
        set.add(45337);
        Tree tree = new Tree(45337, 1, null);
        Random rand = new Random(1337);

        for (int i = 2; i <= 1000000; i++) {
//            tree.addToTree(i, tree);
            int r = rand.nextInt(1000000) + 1;
            if (!set.contains(r)) {
                set.add(r);
                tree.addToTree(r, tree);
            }
        }

        System.out.println("Finished!");
        System.out.println(Tree.deepestLevel);
    }

}

class Tree {
    static int deepestLevel = 0;
    int value;
    int level;

    Tree parent;
    Tree left = null;
    Tree right = null;

    public Tree(int value, int level, Tree parent) {
        this.value = value;
        this.level = level;
        this.parent = parent;
        if (level > Tree.deepestLevel) {
            Tree.deepestLevel = level;
        }
    }

    public void addToTree(int value, Tree tree) {
            if (value < tree.value) {
                if (tree.left == null) {
                    tree.left = new Tree(value, tree.level + 1, tree);
                } else {
                    addToTree(value, tree.left);
                }
            } else if (value > tree.value) {
                if (tree.right == null) {
                    tree.right = new Tree(value, tree.level + 1, tree);
                } else {
                    addToTree(value, tree.right);
                }
            }
    }
}
