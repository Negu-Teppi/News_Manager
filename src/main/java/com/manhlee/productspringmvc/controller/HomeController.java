package com.manhlee.productspringmvc.controller;

import com.manhlee.productspringmvc.entities.ImageEntity;
import com.manhlee.productspringmvc.entities.ProductEntity;
import com.manhlee.productspringmvc.service.CategoryService;
import com.manhlee.productspringmvc.service.ImageService;
import com.manhlee.productspringmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = {"/home", "/products", "/"}, method = RequestMethod.GET)
    public String getAccounts(Model model) {
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("images", imageService.getImages());
        return "products";
    }

    @RequestMapping("/add-products")
    public String addProduct(Model model) {
        model.addAttribute("product", new ProductEntity());
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("action", "add");
        return "product-form";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(Model model, @RequestParam("files") MultipartFile[] files,
                         @ModelAttribute("product") ProductEntity product) {

        Date date = new Date();

        ImageEntity image = new ImageEntity();
        List<ImageEntity> images = new ArrayList<>();
        for (MultipartFile file: files) {
            String fileName = saveImage(file);
            image.setName(fileName);
            images.add(image);
        }
        product.setCreateDate(date);
        product.setImages(images);
        productService.save(product);
        return "redirect:/products";
    }

    private String saveImage(MultipartFile multipartFile) {
        try {
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(servletContext.getRealPath("/images" + multipartFile.getOriginalFilename()));
            Files.write(path, bytes);
            return multipartFile.getOriginalFilename();
        } catch (IOException e) {
            return null;
        }
    }
}
