package esercizi;

import catalogo.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Esercizio3 {
    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(
                new Product(1L, "T-Shirt", "Boys", 20.0),
                new Product(2L, "Jeans", "Girls", 50.0),
                new Product(3L, "Shoes", "Boys", 30.0),
                new Product(4L, "Dress", "Girls", 80.0),
                new Product(5L, "Hat", "Boys", 15.0)
        );

        List<Product> discountedProducts = productList.stream()
                .filter(product -> product.getCategory().equals("Boys"))
                .map(product -> {
                    double discountedPrice = product.getPrice() * 0.9;
                    product.setPrice(discountedPrice);
                    return product;
                })
                .collect(Collectors.toList());

        System.out.println("Prodotti filtrati con sconto del 10%:");
        for (Product product : discountedProducts) {
            System.out.println(product);
        }
    }
}
