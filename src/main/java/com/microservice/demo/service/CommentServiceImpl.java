package com.microservice.demo.service;

import com.microservice.demo.entity.Comment;
import com.microservice.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentRepository commentRepository;
    @Override
    public String postComment(String comment, Integer postId) throws Exception{
        Comment newComment = Comment.builder().comment(comment).postId(postId).build();
        Comment postedComment =  commentRepository.save(newComment);
        if(postedComment != null) {
            return postedComment.getComment();
        }
        else return "";
    }

    public List<Comment> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments;
    }
//    @Override
//    public String updateComment(Integer commentId) throws Exception {
//
//    }
//    @Override
//    public String deleteComment(Integer commentId) throws Exception {
//
//    }

}
