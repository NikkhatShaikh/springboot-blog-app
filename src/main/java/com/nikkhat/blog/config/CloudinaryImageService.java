package com.nikkhat.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryImageService {

        private final Environment env;
        private final Cloudinary cloudinary;

        @Autowired
        public CloudinaryImageService(Environment env) {
            this.env = env;
            String cloudName = env.getProperty("cloudinary.cloud_name");
            String apiKey = env.getProperty("cloudinary.api_key");
            String apiSecret = env.getProperty("cloudinary.api_secret");

            System.out.println("cloudName: " + cloudName);
            System.out.println("apiKey: " + apiKey);
            System.out.println("apiSecret: " + apiSecret);

            this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", cloudName,
                    "api_key", apiKey,
                    "api_secret", apiSecret));
        }


    public String uploadImage(MultipartFile file) throws IOException {
        Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        return (String) uploadResult.get("url");
    }
}
