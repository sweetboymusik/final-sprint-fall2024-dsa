package com.keyin.tree;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Tree {
    // instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<Integer> inputNumbers;

    @Column(columnDefinition = "TEXT")
    private String treeStructure;

    // constructors
    public Tree() {
    }

    public Tree(Long id, List<Integer> inputNumbers, String treeStructure) {
        this.id = id;
        this.inputNumbers = inputNumbers;
        this.treeStructure = treeStructure;
    }

    // getters and setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Integer> getInputNumbers() {
        return this.inputNumbers;
    }

    public void setInputNumbers(List<Integer> inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public String getTreeStructure() {
        return this.treeStructure;
    }

    public void setTreeStructure(String treeStructure) {
        this.treeStructure = treeStructure;
    }

}