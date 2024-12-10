package com.keyin.tree;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/trees")
public class TreeController {
    @Autowired
    private TreeService treeService;

    @PostMapping("/process-numbers")
    public ResponseEntity<?> processNumbers(@RequestBody List<Integer> numbers) {
        try {
            Tree savedTree = treeService.processNumbers(numbers);
            return ResponseEntity.ok(savedTree);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error processing numbers: " + e.getMessage());
        }
    }

    @GetMapping("/previous-trees")
    public Iterable<Tree> getPreviousTrees() {
        return treeService.getPreviousTrees();
    }
}