package com.nikkhat.blog.repository;

import com.nikkhat.blog.entity.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepo  extends MongoRepository<Blog,String> {


}
