package com.keyin.tree;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.BinarySearchTree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeService {

    @Autowired
    private TreeRepository treeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public Iterable<Tree> getAllTrees() {
        return treeRepository.findAll();
    }

    public Tree addTree(Tree treeEntity) {
        return treeRepository.save(treeEntity);
    }

    public Tree getTreeById(Long id) {
        return treeRepository.findById(id).orElseThrow();
    }

    public Tree processNumbers(List<Integer> numbers) {
        BinarySearchTree bst = new BinarySearchTree();
        numbers.forEach(bst::insert);

        try {
            String treeJson = objectMapper.writeValueAsString(bst.toTreeStructure());

            // Save to repository
            Tree treeEntity = new Tree();
            treeEntity.setInputNumbers(numbers);
            treeEntity.setTreeStructure(treeJson);

            return treeRepository.save(treeEntity);

        } catch (Exception e) {
            throw new RuntimeException("Error processing numbers: " + e.getMessage(), e);
        }
    }

    public Iterable<Tree> getPreviousTrees() {
        return treeRepository.findAll();
    }

    public void deleteTreeById(Long id) {
        Tree treeToDelete = getTreeById(id);
        treeRepository.delete(treeToDelete);

    }

    public Tree updateTreeById(Long id, Tree updatedTree) {
        Tree treeToUpdate = getTreeById(id);

        if (updatedTree.getInputNumbers() != null && !updatedTree.getInputNumbers().isEmpty()) {
            treeToUpdate.setInputNumbers(updatedTree.getInputNumbers());
        }
        if (updatedTree.getTreeStructure() != null) {
            treeToUpdate.setTreeStructure(updatedTree.getTreeStructure());
        }

        return treeRepository.save(treeToUpdate);
    }
}