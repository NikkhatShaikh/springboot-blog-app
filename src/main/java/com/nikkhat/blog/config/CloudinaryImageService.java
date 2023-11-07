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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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


    public Map<String, Object> uploadImage(MultipartFile file) {
        Map<String, Object> map = new HashMap<>();

        try {
            Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            Optional<String> imageUrl = Optional.ofNullable((String) uploadResult.get("url"));

            imageUrl.ifPresent(url -> {
                map.put("imageUrl", url);
            });
        } catch (IOException e) {
            e.printStackTrace();
            map.put("error", "An error occurred during image upload.");
        }

        return map;
    }
}
