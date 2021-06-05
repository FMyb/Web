package ru.itmo.wp.service;

import org.springframework.stereotype.Service;
import ru.itmo.wp.domain.Comment;
import ru.itmo.wp.domain.Post;
import ru.itmo.wp.form.CommentForm;
import ru.itmo.wp.repository.CommentRepository;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Post writeComment(CommentForm commentForm) {
        Comment comment = new Comment();
        Post post = commentForm.getPost();
        comment.setUser(commentForm.getUser());
        comment.setPost(commentForm.getPost());
        comment.setText(commentForm.getText());
        commentRepository.save(comment);
        post.getComments().add(comment);
        return post;
    }
}
