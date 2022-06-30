package ru.netology.manager.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    Product book1 = new Book(1, "Мастер и Маргарита", 300, "Булгаков");
    Product phone1 = new Smartphone(2, "iPhone5", 15000, "Apple");
    Product phone2 = new Smartphone(3, "iPhone4S", 17500, "Apple");
    Product phone3 = new Smartphone(4, "8800", 33400, "Nokia");
    Product book2 = new Book(5, "Мумий Троль", 450, "Туве Ярссон");
    Product book3 = new Book(6, "Герой нашего времени", 740, "Лермонтов");


    @Test
    public void firstTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(book2);
        manager.add(book3);
        manager.removeById(2);
        manager.findAll();

        Product[] actual = manager.searchBy("М");
        Product[] expected = {book1, book2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchesTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(book2);
        manager.add(book3);


        Product[] actual = manager.searchBy("Ap");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void secondTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("88");
        Product[] expected = {phone3};
        Assertions.assertArrayEquals(expected, actual);

        ProductRepository repo1 = new ProductRepository();
        ProductManager manager1 = new ProductManager(repo1);

        Product[] actual1 = manager1.searchBy("М");
        Product[] expected1 = {};
        Assertions.assertArrayEquals(expected, actual);

    }
}
