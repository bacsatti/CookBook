package hu.bme.homework.cookbook.dbservice.controller;

import hu.bme.homework.cookbook.dbservice.persistance.Comment;
import hu.bme.homework.cookbook.dbservice.persistance.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/{title}")
    public List<Comment> getOne(@PathVariable("title") String title){

        return commentRepository.findAll();

    }
    @PostMapping("/add")
    public Comment addComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }
}