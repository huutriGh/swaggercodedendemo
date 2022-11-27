package com.example.demoswaggercodegen.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demoswaggercodegen.model.Blog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Repository
@Getter
@Setter
@NoArgsConstructor
public class BlogRepository {

    private List<Blog> initialBlog() {
        ArrayList<Blog> list = new ArrayList<Blog>();
        Blog blog1 = new Blog();
        blog1.setBlogId(1L);
        blog1.setRating(5);
        blog1.setUrl("http://localhost:8080/v1/blog/1");
        Blog blog2 = new Blog();
        blog2.setBlogId(2L);
        blog2.setRating(5);
        blog2.setUrl("http://localhost:8080/v1/blog/2");
        Blog blog3 = new Blog();
        blog3.setBlogId(3L);
        blog3.setRating(5);
        blog3.setUrl("http://localhost:8080/v1/blog/3");
        list.add(blog1);
        list.add(blog2);
        list.add(blog3);

        return list;
    }

    private List<Blog> blogs = initialBlog();

}
