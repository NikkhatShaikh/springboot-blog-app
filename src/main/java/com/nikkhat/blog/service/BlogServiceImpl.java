package com.nikkhat.blog.service;

import com.nikkhat.blog.entity.Blog;
import com.nikkhat.blog.exception.ResourceNotFoundException;
import com.nikkhat.blog.repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepo blogRepo;

    @Override
    public Blog createBlog(Blog blog) {

//        String Id = UUID.randomUUID().toString();
//        blog.setBlog_id(Id);
        return blogRepo.save(blog);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();
    }

    @Override
    public Blog getBlogById(String blog_id) {
        return blogRepo.findById(blog_id).orElseThrow(() -> new ResourceNotFoundException("Blog with given Id is not Found In DB " + blog_id));

    }

    @Override
    public Blog updateBlog(String blog_id, Blog updatedBlog) {
        Instant currentDate = Instant.now();
        Blog existingBlog = blogRepo.findById(blog_id)
                .orElseThrow(() -> new RuntimeException("Blog not found"));


        existingBlog.setBlog_title(updatedBlog.getBlog_title());
        existingBlog.setBlog_description(updatedBlog.getBlog_description());
        existingBlog.setBlog_image_url(updatedBlog.getBlog_image_url());
        existingBlog.setUpdated_date(currentDate);
        existingBlog.setUpdated_by(updatedBlog.getUpdated_by());
        return blogRepo.save(existingBlog);
    }
}
