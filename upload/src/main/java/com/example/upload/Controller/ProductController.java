package com.example.upload.Controller;

import com.example.upload.Model.Product;
import com.example.upload.Model.ProductForm;
import com.example.upload.Service.IProductService;
import com.example.upload.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {
    @Value("${file-upload}")
//    localfileUpload tên đường dẫn để lưu file
    private String localfileUpload;
    @Autowired
    public IProductService productService;

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/index";
    }
    @ModelAttribute(value = "productForm")
    public ProductForm product () {
        return new ProductForm();
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("productForm");
        return modelAndView;
    }
//    @ModelAttribute(value ="productForm")
//    public ProductForm productForm ( ){
////        return  new ProductForm();
//    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute ProductForm productForm) {
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(localfileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Product product = new Product(productForm.getId(), productForm.getName(),
                productForm.getDescription(), fileName);
        productService.save(product);
     return "redirect:/product";
    }
}
