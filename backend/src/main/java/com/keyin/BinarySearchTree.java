package com.keyin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinarySearchTree {
    BinaryNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    static class BinaryNode {
        int value;
        BinaryNode left;
        BinaryNode right;

        BinaryNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private BinaryNode insertRecursive(BinaryNode current, int value) {
        if (current == null) {
            return new BinaryNode(value);
        }

        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    public List<Integer> inOrderTraversal() {
        List<Integer> sortedList = new ArrayList<>();
        inOrderTraversal(root, sortedList);
        return sortedList;
    }

    private void inOrderTraversal(BinaryNode node, List<Integer> sortedList) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, sortedList);
        sortedList.add(node.value);
        inOrderTraversal(node.right, sortedList);
    }

    public void buildBalancedTree(List<Integer> sortedNumbers, int start, int end) {
        root = buildBalancedTreeRecursive(sortedNumbers, start, end);
    }

    private BinaryNode buildBalancedTreeRecursive(List<Integer> sortedNumbers, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        BinaryNode node = new BinaryNode(sortedNumbers.get(mid));
        node.left = buildBalancedTreeRecursive(sortedNumbers, start, mid - 1);
        node.right = buildBalancedTreeRecursive(sortedNumbers, mid + 1, end);
        return node;
    }

    // preorder traversal
    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");

        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);

        System.out.print(node.value + " ");

        inOrder(node.right);
    }

    public void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);

        System.out.print(node.value + " ");
    }

    public void levelOrder() {
        if (root == null) {
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode current = queue.remove();
            System.out.print(current.value + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(BinaryNode current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        return value < current.value
                ? searchRecursive(current.left, value)
                : searchRecursive(current.right, value);
    }

    // delete a value from the tree
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private BinaryNode deleteRecursive(BinaryNode current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.left == null) {
                return current.right;
            }

            if (current.right == null) {
                return current.left;
            }

            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);

            return current;
        }

        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(BinaryNode root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public Map<String, Object> toTreeStructure() {
        return toTreeStructure(root);
    }

    private Map<String, Object> toTreeStructure(BinaryNode node) {
        if (node == null) {
            return null;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("value", node.value);
        map.put("left", toTreeStructure(node.left));
        map.put("right", toTreeStructure(node.right));
        return map;
    }

    public void printTree() {
        inOrder(root);
        System.out.println();
    }
}