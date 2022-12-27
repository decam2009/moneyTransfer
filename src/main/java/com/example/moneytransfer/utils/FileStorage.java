package com.example.moneytransfer.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class FileStorage {
    @Value("${file.path:''}")
    String filePath;

}
