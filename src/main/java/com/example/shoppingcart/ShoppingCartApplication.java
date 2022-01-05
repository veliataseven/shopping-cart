package com.example.shoppingcart;

import com.example.shoppingcart.models.CreditCard;
import com.example.shoppingcart.models.Customer;
import com.example.shoppingcart.models.Product;
import com.example.shoppingcart.models.ShoppingCart;
import com.example.shoppingcart.repositories.CreditCardRepository;
import com.example.shoppingcart.repositories.CustomerRepository;
import com.example.shoppingcart.repositories.ProductRepository;
import com.example.shoppingcart.repositories.ShoppingCartRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.ArrayList;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ShoppingCartApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final CreditCardRepository creditCardRepository;
    private final ProductRepository productRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartApplication(
            CustomerRepository customerRepository,
            CreditCardRepository creditCardRepository,
            ProductRepository productRepository,
            ShoppingCartRepository shoppingCartRepository) {
        this.customerRepository = customerRepository;
        this.creditCardRepository = creditCardRepository;
        this.productRepository = productRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        CreditCard newCreditCard = new CreditCard(1234567890);
        creditCardRepository.save(newCreditCard);

        Customer newCustomer = new Customer("johndoe@customer.com", newCreditCard, "John", "Doe");
        customerRepository.save(newCustomer);

        Product newProduct = new Product("pen", 5);
        productRepository.save(newProduct);

        ShoppingCart newShoppingCart = new ShoppingCart(new ArrayList());
        newShoppingCart.getProducts().add(newProduct);
        shoppingCartRepository.save(newShoppingCart);
    }
}
