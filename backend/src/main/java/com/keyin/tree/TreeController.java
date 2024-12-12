package com.keyin.tree;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/trees")
@CrossOrigin(origins = "http://localhost:3000")
public class TreeController {
    @Autowired
    private TreeService treeService;

    @PostMapping("/process-numbers")
    public ResponseEntity<Tree> processNumbers(@RequestBody List<Integer> numbers) {
        try {
            Tree savedTree = treeService.processNumbers(numbers);
            return ResponseEntity.ok(savedTree);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/previous-trees")
    public Iterable<Tree> getPreviousTrees() {
        return treeService.getPreviousTrees();
    }

    @PostMapping("/process-and-balance")
    public ResponseEntity<Tree> processAndBalanceNumbers(@RequestBody List<Integer> numbers) {
        try {
            Tree savedTree = treeService.processAndBalanceNumbers(numbers);
            return ResponseEntity.ok(savedTree);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}