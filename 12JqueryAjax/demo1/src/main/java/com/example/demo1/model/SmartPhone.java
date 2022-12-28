package com.example.demo1.model;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.persistence.*;
@Entity
public class SmartPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String product;
    private String model;
    private double price;

    public SmartPhone() {
    }

    public SmartPhone(Long id, String product, String model, double price) {
        this.id = id;
        this.product = product;
        this.model = model;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
