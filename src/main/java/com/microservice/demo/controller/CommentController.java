package com.microservice.demo.controller;

import com.microservice.demo.entity.Comment;
import com.microservice.demo.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/comment")
@RestController
public class CommentController {
    @Autowired
    CommentServiceImpl commentServiceImpl;

    @PostMapping
    public ResponseEntity<?> postComment(@RequestParam String comment, @RequestParam Integer postId) throws Exception {
        try {
            String postedComment = commentServiceImpl.postComment(comment, postId);
            if (postedComment != null && !postedComment.toString().equals("")) {
                return new ResponseEntity<>("Comment Successfully Posted", HttpStatus.OK);
            } else return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllComments() throws Exception {
        List<Comment> commentsList = commentServiceImpl.getAllComments();
        return new ResponseEntity<>(commentsList, HttpStatus.OK);
    }
}