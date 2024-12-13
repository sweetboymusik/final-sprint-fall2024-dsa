package com.keyin;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void testInsert() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        assertTrue(bst.search(10));
        assertTrue(bst.search(5));
        assertTrue(bst.search(15));
        assertFalse(bst.search(20));
    }

    @Test
    void testInOrderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        List<Integer> expectedOrder = Arrays.asList(5, 10, 15);
        assertEquals(expectedOrder, bst.inOrderTraversal());
    }

    @Test
    void testBuildBalancedTree() {
        BinarySearchTree bst = new BinarySearchTree();
        List<Integer> sortedNumbers = Arrays.asList(5, 10, 15, 20, 25);
        bst.buildBalancedTree(sortedNumbers, 0, sortedNumbers.size() - 1);

        List<Integer> expectedOrder = Arrays.asList(5, 10, 15, 20, 25);
        assertEquals(expectedOrder, bst.inOrderTraversal());
    }

    @Test
    void testSearch() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        assertTrue(bst.search(5));
        assertFalse(bst.search(20));
    }

    @Test
    void testDeleteLeafNode() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        bst.delete(5);
        assertFalse(bst.search(5));
        assertTrue(bst.search(10));
        assertTrue(bst.search(15));
    }

    @Test
    void testDeleteNodeWithOneChild() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);

        bst.delete(5);
        assertFalse(bst.search(5));
        assertTrue(bst.search(3));
        assertTrue(bst.search(10));
        assertTrue(bst.search(15));
    }

    @Test
    void testDeleteNodeWithTwoChildren() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);

        bst.delete(5);
        assertFalse(bst.search(5));
        assertTrue(bst.search(3));
        assertTrue(bst.search(7));
        assertTrue(bst.search(10));
        assertTrue(bst.search(15));
    }

    @Test
    void testToTreeStructure() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        Map<String, Object> treeStructure = bst.toTreeStructure();

        assertEquals(10, treeStructure.get("value"));
        assertNotNull(treeStructure.get("left"));
        assertNotNull(treeStructure.get("right"));
    }
}