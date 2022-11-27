package com.example.demoswaggercodegen.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demoswaggercodegen.api.BlogApiDelegate;
import com.example.demoswaggercodegen.model.Blog;
import com.example.demoswaggercodegen.repository.BlogRepository;

@Service
public class BlogService implements BlogApiDelegate {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public ResponseEntity<List<Blog>> getBlogs() {
        return ResponseEntity.ok(blogRepository.getBlogs());
    }

    @Override
    public ResponseEntity<String> addBlog(@Valid Blog blog) {

        if (blogRepository.getBlogs().stream().anyMatch(item -> item.getBlogId().equals(blog.getBlogId()))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Blog is duplicated!!!");
        }
        blogRepository.getBlogs().add(blog);
        return ResponseEntity.ok("Blog is added");

    }

}
