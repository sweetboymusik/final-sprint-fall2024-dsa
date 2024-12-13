package com.keyin.tree;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TreeServiceTest {

    @Mock
    private TreeRepository treeRepository;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private TreeService treeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTrees() {
        Iterable<Tree> mockTrees = Arrays
                .asList(new Tree(1L, Arrays.asList(10, 20), "{\"value\":10,\"right\":{\"value\":20}}"));
        when(treeRepository.findAll()).thenReturn(mockTrees);

        Iterable<Tree> result = treeService.getAllTrees();

        assertNotNull(result);
        assertEquals(mockTrees, result);
        verify(treeRepository, times(1)).findAll();
    }

    @Test
    void testAddTree() {
        Tree mockTree = new Tree(1L, Arrays.asList(10, 20), "{\"value\":10,\"right\":{\"value\":20}}");
        when(treeRepository.save(any(Tree.class))).thenReturn(mockTree);

        Tree result = treeService.addTree(mockTree);

        assertNotNull(result);
        assertEquals(mockTree, result);
        verify(treeRepository, times(1)).save(mockTree);
    }

    @Test
    void testGetTreeById() {
        Tree mockTree = new Tree(1L, Arrays.asList(10, 20), "{\"value\":10,\"right\":{\"value\":20}}");
        when(treeRepository.findById(1L)).thenReturn(Optional.of(mockTree));

        Tree result = treeService.getTreeById(1L);

        assertNotNull(result);
        assertEquals(mockTree, result);
        verify(treeRepository, times(1)).findById(1L);
    }

    @Test
    void testProcessNumbers() throws Exception {
        List<Integer> numbers = Arrays.asList(10, 20);
        String treeJson = "{\"value\":10,\"right\":{\"value\":20}}";

        when(objectMapper.writeValueAsString(any())).thenReturn(treeJson);
        when(treeRepository.save(any(Tree.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Tree result = treeService.processNumbers(numbers);

        assertNotNull(result);
        assertEquals(numbers, result.getInputNumbers());
        assertEquals(treeJson, result.getTreeStructure());
        verify(treeRepository, times(1)).save(any(Tree.class));
    }

    @Test
    void testProcessAndBalanceNumbers() throws Exception {
        List<Integer> numbers = Arrays.asList(10, 20, 30);
        String balancedTreeJson = "{\"value\":20,\"left\":{\"value\":10},\"right\":{\"value\":30}}";

        when(objectMapper.writeValueAsString(any())).thenReturn(balancedTreeJson);
        when(treeRepository.save(any(Tree.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Tree result = treeService.processAndBalanceNumbers(numbers);

        assertNotNull(result);
        assertEquals(numbers, result.getInputNumbers());
        assertEquals(balancedTreeJson, result.getTreeStructure());
        verify(treeRepository, times(1)).save(any(Tree.class));
    }

    @Test
    void testDeleteTreeById() {
        Tree mockTree = new Tree(1L, Arrays.asList(10, 20), "{\"value\":10,\"right\":{\"value\":20}}");
        when(treeRepository.findById(1L)).thenReturn(Optional.of(mockTree));

        treeService.deleteTreeById(1L);

        verify(treeRepository, times(1)).delete(mockTree);
    }

    @Test
    void testUpdateTreeById() {
        Tree existingTree = new Tree(1L, Arrays.asList(10, 20), "{\"value\":10,\"right\":{\"value\":20}}");
        Tree updatedTree = new Tree(1L, Arrays.asList(10, 15, 20),
                "{\"value\":15,\"left\":{\"value\":10},\"right\":{\"value\":20}}");

        when(treeRepository.findById(1L)).thenReturn(Optional.of(existingTree));
        when(treeRepository.save(any(Tree.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Tree result = treeService.updateTreeById(1L, updatedTree);

        assertNotNull(result);
        assertEquals(updatedTree.getInputNumbers(), result.getInputNumbers());
        assertEquals(updatedTree.getTreeStructure(), result.getTreeStructure());
        verify(treeRepository, times(1)).save(existingTree);
    }
}