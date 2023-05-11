package esercizi;

import catalogo.Product;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Esercizio1 {
    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(
                new Product(1L, "SignoreAnelli", "Books", 50.0),
                new Product(2L, "HarryPotter", "Books", 120.0),
                new Product(3L, "JasonBourne", "Electronics", 80.0),
                new Product(4L, "DonatoCarrisi", "Books", 150.0),
                new Product(5L, "MarcelloSimoni", "Books", 90.0)
        );

        Predicate<Product> categoryPredicate = product -> product.getCategory().equals("Books");
        Predicate<Product> pricePredicate = product -> product.getPrice() > 100.0;

        List<Product> filteredProducts = productList.stream()
                .filter(categoryPredicate)
                .filter(pricePredicate)
                .collect(Collectors.toList());

        System.out.println("Prodotti della categoria 'Books' con prezzo > 100:");
        for (Product product : filteredProducts) {
            System.out.println(product);
        }
    }
}
