package esercizi;

import catalogo.Customer;
import catalogo.Order;
import catalogo.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Esercizio4 {
    public static void main(String[] args) {
        List<Order> orderList = Arrays.asList(
                new Order(1L, "In progress", LocalDate.of(2021, 3, 15), LocalDate.of(2021, 3, 20),
                        Arrays.asList(
                                new Product(1L, "Shirt", "Men", 30.0),
                                new Product(2L, "Jeans", "Men", 50.0),
                                new Product(3L, "Shoes", "Men", 80.0)
                        ),
                        new Customer(1L, "Mario Rossi", 2)
                ),
                new Order(2L, "Delivered", LocalDate.of(2021, 2, 10), LocalDate.of(2021, 2, 15),
                        Arrays.asList(
                                new Product(4L, "Dress", "Women", 60.0),
                                new Product(5L, "Skirt", "Women", 40.0)
                        ),
                        new Customer(2L, "Luigi Verdi", 3)
                ),
                new Order(3L, "In progress", LocalDate.of(2021, 4, 5), LocalDate.of(2021, 4, 10),
                        Arrays.asList(
                                new Product(6L, "T-Shirt", "Men", 20.0),
                                new Product(7L, "Shorts", "Men", 35.0)
                        ),
                        new Customer(3L, "Marina Stella", 2)
                )
        );

        Predicate<Order> tierPredicate = order -> order.getCustomer().getTier() == 2;
        Predicate<Order> datePredicate = order -> order.getOrderDate().isAfter(LocalDate.of(2021, 1, 31)) &&
                order.getOrderDate().isBefore(LocalDate.of(2021, 4, 2));

        List<Product> filteredProducts = orderList.stream()
                .filter(tierPredicate.and(datePredicate))
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toList());

        System.out.println("Prodotti ordinati da clienti di tier 2 tra l'01-Feb-2021 e l'01-Apr-2021:");
        for (Product product : filteredProducts) {
            System.out.println(product);
        }
    }
}
