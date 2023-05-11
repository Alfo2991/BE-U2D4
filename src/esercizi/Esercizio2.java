package esercizi;

import catalogo.Order;
import catalogo.Product;
import catalogo.Customer;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Esercizio2 {
    public static void main(String[] args) {
        List<Order> orderList = Arrays.asList(
                new Order(1L, "In progress", LocalDate.of(2023, 5, 20), LocalDate.of(2023, 5, 25),
                        Arrays.asList(
                                new Product(1L, "DonatoCarrisi", "Books", 150.0),
                                new Product(2L, "JasonBourne", "Books", 80.0)
                        ),
                        new Customer(1L, "Mario Rossi", 1)),
                new Order(2L, "Delivered", LocalDate.of(2023, 5, 15), LocalDate.of(2023, 5, 18),
                        Arrays.asList(
                                new Product(3L, "Pannolini", "Baby", 10.0),
                                new Product(4L, "Biberon", "Baby", 5.0)
                        ),
                        new Customer(2L, "Luigi Verdi", 2)),
                new Order(3L, "In progress", LocalDate.of(2023, 5, 10), LocalDate.of(2023, 5, 15),
                        Arrays.asList(
                                new Product(5L, "Toy", "Toys", 20.0),
                                new Product(6L, "HarryPotter", "Books", 120.0)
                        ),
                        new Customer(3L, "Marina Stella", 3))
        );

        Predicate<Order> categoryPredicate = order -> order.getProducts().stream()
                .anyMatch(product -> product.getCategory().equals("Baby"));

        List<Order> filteredOrders = orderList.stream()
                .filter(categoryPredicate)
                .collect(Collectors.toList());

        System.out.println("Ordini filtrati:");
        for (Order order : filteredOrders) {
            System.out.println(order);
        }
    }
}
