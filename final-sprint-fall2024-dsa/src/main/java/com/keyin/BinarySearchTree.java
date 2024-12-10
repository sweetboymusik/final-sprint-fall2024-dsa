package com.keyin;

import java.util.HashMap;
import java.util.Map;

public class BinarySearchTree {
    private Node root;

    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }
        return current;
    }

    public Map<String, Object> toMap() {
        return nodeToMap(root);
    }

    private Map<String, Object> nodeToMap(Node node) {
        if (node == null)
            return null;

        @SuppressWarnings({ "unchecked", "rawtypes" })
        Map<String, Object> map = new HashMap();
        map.put("value", node.value);
        map.put("left", nodeToMap(node.left));
        map.put("right", nodeToMap(node.right));
        return map;
    }
}