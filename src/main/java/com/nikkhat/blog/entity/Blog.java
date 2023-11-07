package com.nikkhat.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document("blog")

public class Blog {
    @Id
    private String blog_id;
    private String blog_title;
    private String blog_description;
    private String blog_image_url;
    private Instant createdDate = Instant.now();
    private Instant updated_date;
    private String created_by = "JAVA";
    private String updated_by;
}
