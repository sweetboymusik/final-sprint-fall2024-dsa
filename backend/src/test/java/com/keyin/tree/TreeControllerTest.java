package com.keyin.tree;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class TreeControllerTest {

    @Mock
    private TreeService treeService;

    @InjectMocks
    private TreeController treeController;

    public TreeControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessNumbers() {
        List<Integer> inputNumbers = Arrays.asList(3, 1, 4, 1, 5);
        Tree mockTree = new Tree(1L, inputNumbers, "{\"value\":3,\"left\":{\"value\":1},\"right\":{\"value\":4}}");

        when(treeService.processNumbers(inputNumbers)).thenReturn(mockTree);

        ResponseEntity<Tree> response = treeController.processNumbers(inputNumbers);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockTree, response.getBody());
    }

    @Test
    void testGetPreviousTrees() {
        Tree tree1 = new Tree(1L, Arrays.asList(3, 1, 4), "{\"value\":3}");
        Tree tree2 = new Tree(2L, Arrays.asList(5, 9, 2), "{\"value\":5}");
        List<Tree> mockTrees = Arrays.asList(tree1, tree2);

        when(treeService.getPreviousTrees()).thenReturn(mockTrees);

        Iterable<Tree> response = treeController.getPreviousTrees();

        assertEquals(mockTrees, response);
    }

    @Test
    void testProcessAndBalanceNumbers() {
        List<Integer> inputNumbers = Arrays.asList(7, 3, 9, 1, 5);
        Tree mockTree = new Tree(1L, inputNumbers,
                "{\"value\":5,\"left\":{\"value\":3,\"left\":{\"value\":1}},\"right\":{\"value\":7}}");

        when(treeService.processAndBalanceNumbers(inputNumbers)).thenReturn(mockTree);

        ResponseEntity<Tree> response = treeController.processAndBalanceNumbers(inputNumbers);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockTree, response.getBody());
    }
}