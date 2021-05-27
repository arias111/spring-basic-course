package com.spring.basics.services.interfaces;

import com.spring.basics.models.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AdminService {
    String addProd(Product form, MultipartFile file) throws IOException;

}
