package com.nikkhat.blog.service;

import com.nikkhat.blog.entity.Blog;

import java.util.List;

public interface BlogService {


    Blog createBlog (Blog blog);

    List<Blog> getAllBlogs();

    Blog getBlogById(String blog_id);

    Blog updateBlog(String blog_id,Blog updatedBlog);
}
