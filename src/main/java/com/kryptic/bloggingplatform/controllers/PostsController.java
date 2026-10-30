package com.kryptic.bloggingplatform.controllers;

import com.kryptic.bloggingplatform.entity.Posts;
import com.kryptic.bloggingplatform.repository.PostsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostsController {

    private final PostsRepository postsRepository;

    public PostsController(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    // Create a post (C)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Posts createPosts(@RequestBody Posts posts) {
        return postsRepository.save(posts);
    }

    // Read all posts (R)
    @GetMapping
    public List<Posts> getAllPosts() {
        return postsRepository.findAll();
    }

    // Read a post by ID (R)
    @GetMapping("/{id}")
    public Posts getPostsById(@PathVariable Long id) {
        return postsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Post not found with ID: " + id
                ));
    }

    // Update a post (U)
    @PutMapping("/{id}")
    public Posts updatePostsById(
            @PathVariable Long id,
            @RequestBody Posts postsDetails) {

        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Post not found with ID: " + id
                ));

        posts.setTitle(postsDetails.getTitle());
        posts.setContent(postsDetails.getContent());
        posts.setCategory(postsDetails.getCategory());
        posts.setTags(postsDetails.getTags());

        return postsRepository.save(posts);
    }

    // Delete a post (D)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePostsById(@PathVariable Long id) {
        if (!postsRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Post not found with ID: " + id
            );
        }

        postsRepository.deleteById(id);
    }
}