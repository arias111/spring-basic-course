package com.spring.basics.services.impletentations;

import com.spring.basics.models.Product;
import com.spring.basics.repositories.ProductsRepository;
import com.spring.basics.services.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private ProductsRepository productsRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public String addProd(Product form, MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));

            form.setImageName(resultFileName);
            productsRepository.save(form);
            return "Товар добавлен";
        }
        return "Товар не добавлен";
    }
}
