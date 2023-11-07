package com.nikkhat.blog.controller;

import com.nikkhat.blog.entity.Blog;
import com.nikkhat.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.PrimitiveIterator;

@RestController
@RequestMapping("/api")
public class BlogRestController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/blog")
    ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
        return ResponseEntity.status(HttpStatus.CREATED).body(blogService.createBlog(blog));
    }

    @GetMapping("/blogs")
    public List<Blog> getBlogs(){
        return blogService.getAllBlogs();
    }

    @GetMapping("/blog")
    public Blog getBlogDetails(@RequestParam String blogId){
        return blogService.getBlogById(blogId);
    }


    @PutMapping("/blog/{blog_id}")
    public Blog updateBlog(@PathVariable String blog_id, @RequestBody Blog updatedBlog) {
        return blogService.updateBlog(blog_id, updatedBlog);
    }
}
