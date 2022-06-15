package firstproject.javaspringboot.db;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DBManager {
    private Long id = 0L;
    private ArrayList<Products> products = new ArrayList<>();

    {
        products.add(new Products(++id, "iPhone 11","8GB RAM 256GB SSD", 320000));
        products.add(new Products(++id, "iPhone 12","16GB RAM 512GB SSD", 420000));
        products.add(new Products(++id, "iPhone 13","16GB RAM 1024GB SSD", 530000));
        products.add(new Products(++id, "iPhone 14","32GB RAM 1024GB SSD", 580000));
        products.add(new Products(++id, "iPhone 15","32GB RAM 512GB SSD", 6500000));
    }

    public ArrayList<Products> getAllProducts() {
        return products;
    }

    public void addProduct(Products product) {
        product.setId(++id);
        products.add(product);
    }

    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}
